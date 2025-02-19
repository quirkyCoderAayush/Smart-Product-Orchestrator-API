package com.publicissapient.products_api.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Dimensions {

	private Double width;
	private Double height;
	private Double depth;

}
