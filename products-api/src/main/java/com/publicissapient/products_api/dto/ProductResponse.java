package com.publicissapient.products_api.dto;

import java.util.List;

import com.publicissapient.products_api.model.Product;

import lombok.Data;

@Data
public class ProductResponse {
	private List<Product> products;
	private Integer total;
	private Integer skip;
	private Integer limit;
}