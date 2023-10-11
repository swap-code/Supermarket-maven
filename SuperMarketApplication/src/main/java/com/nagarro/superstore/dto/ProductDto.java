package com.nagarro.superstore.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * ProductDto class for data transfer between DAO and service layers
 *
 * @author rishabhsinghla
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductDto {

	private int productId;

	private String category;

	private String productName;

	private String description;

	private int quantity;

	private int price;

	private LocalDate addedDate;

}
