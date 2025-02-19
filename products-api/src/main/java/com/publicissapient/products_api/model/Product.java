package com.publicissapient.products_api.model;

import java.util.List;

import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
@Indexed(index = "product_idx")
public class Product {
	@Id
	private Long id;

	@FullTextField(analyzer = "english")
	private String title;

	@FullTextField(analyzer = "english")
	private String description;

	@KeywordField
	private String category;

	@KeywordField
	private String brand;

	@KeywordField
	private String sku;

	private Double price;
	private Double discountPercentage;
	private Double rating;
	private Integer stock;

	@ElementCollection
	private List<String> tags;

	private Integer weight;

	@Embedded
	private Dimensions dimensions;

	private String warrantyInformation;
	private String shippingInformation;
	private String availabilityStatus;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Review> reviews;

	private String returnPolicy;
	private Integer minimumOrderQuantity;

	@Embedded
	private Meta meta;

	@ElementCollection
	private List<String> images;

	private String thumbnail;
}