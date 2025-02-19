package com.publicissapient.products_api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.publicissapient.products_api.dto.ProductResponse;
import com.publicissapient.products_api.model.Product;
import com.publicissapient.products_api.repository.ProductRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

	@Autowired
	private final ProductRepository productRepository;
	@Autowired
	private final SearchService searchService;
	@Autowired
	private final RestTemplate restTemplate;

	@CircuitBreaker(name = "externalAPI", fallbackMethod = "loadProductsFallback")
	public void loadProductsFromExternalApi() {
		log.info("Loading products from external API");
		String url = "https://dummyjson.com/products";
		ProductResponse response = restTemplate.getForObject(url, ProductResponse.class);
		log.debug("Received response: {}", response); 
		if (response != null && response.getProducts() != null) {
			productRepository.saveAll(response.getProducts());
			searchService.initializeHibernateSearch();
			log.info("Successfully loaded {} products", response.getProducts().size());
		}
	}

	private void loadProductsFallback(Exception e) {
		log.error("External API call failed: {}", e.getMessage());
		// Load default/cached products or return empty response
		List<Product> defaultProducts = getDefaultProducts();
		if (!defaultProducts.isEmpty()) {
			productRepository.saveAll(defaultProducts);
			searchService.initializeHibernateSearch();
			log.info("Loaded {} default products", defaultProducts.size());
		}
	}

	private List<Product> getDefaultProducts() {
		// Return a list of default products or fetch from cache
		return new ArrayList<>();
	}

	public List<Product> getAllProducts() {
		log.info("Fetching all products");
		return productRepository.findAll();
	}

	public Optional<Product> findProduct(String identifier) {
		log.info("Finding product by identifier: {}", identifier);
		try {
			Long id = Long.parseLong(identifier);
			return productRepository.findById(id);
		} catch (NumberFormatException e) {
			return productRepository.findBySku(identifier);
		}
	}
}
