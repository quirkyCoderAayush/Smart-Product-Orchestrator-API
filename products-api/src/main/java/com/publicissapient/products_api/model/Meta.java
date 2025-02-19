package com.publicissapient.products_api.model;

import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Meta {

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private String barcode;
	private String qrCode;

}
