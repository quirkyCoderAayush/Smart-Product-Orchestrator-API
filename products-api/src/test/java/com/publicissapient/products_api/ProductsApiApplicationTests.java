package com.publicissapient.products_api;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import com.publicissapient.products_api.dto.ProductResponse;
import com.publicissapient.products_api.model.Product;
import com.publicissapient.products_api.service.ProductService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductsApiApplicationTests {

	@Autowired
	private ProductService productService;

	@MockBean
	private RestTemplate restTemplate;

	@Test
	void whenLoadProducts_thenSuccess() {
		ProductResponse mockResponse = new ProductResponse();
		List<Product> products = Arrays.asList(new Product(), new Product());
		mockResponse.setProducts(products);

		when(restTemplate.getForObject("https://dummyjson.com/products", ProductResponse.class))
				.thenReturn(mockResponse);

		productService.loadProductsFromExternalApi();

		verify(restTemplate).getForObject(anyString(), eq(ProductResponse.class));
	}

}
