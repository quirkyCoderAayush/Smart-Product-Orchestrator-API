package com.publicissapient.products_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.publicissapient.products_api.model.Product;
import com.publicissapient.products_api.service.ProductService;
import com.publicissapient.products_api.service.SearchService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Tag(name = "Products API", description = "Operations for managing products")
public class ProductController {

	@Autowired
	private final ProductService productService;

	@Autowired
	private final SearchService searchService;

	@PostMapping("/load")
	@Operation(summary = "Load products from external API")
	@ApiResponse(responseCode = "200", description = "Products loaded successfully")
	public ResponseEntity<String> loadProducts() {
		productService.loadProductsFromExternalApi();
		return ResponseEntity.ok("Products loaded successfully into database");
	}

	@GetMapping("/search")
	public ResponseEntity<List<Product>> searchProducts(@RequestParam String term) {
		List<Product> results = searchService.fuzzySearch(term);
		return ResponseEntity.ok(results);
	}

	@GetMapping
	@Operation(summary = "Get all products")
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(productService.getAllProducts());
	}

	@GetMapping("/{identifier}")
	@Operation(summary = "Find product by ID or SKU")
	public ResponseEntity<Product> getProduct(@PathVariable String identifier) {
		Optional<Product> product = productService.findProduct(identifier);
		if (product.isPresent()) {
			return ResponseEntity.ok(product.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.header("X-Error-Message", "Product not found with identifier: " + identifier).build();
	}
	
}