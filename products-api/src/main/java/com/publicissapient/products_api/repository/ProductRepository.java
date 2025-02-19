package com.publicissapient.products_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.publicissapient.products_api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findBySku(String sku);

}