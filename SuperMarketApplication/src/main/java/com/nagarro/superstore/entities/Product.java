package com.nagarro.superstore.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Class for storing business data
 *
 * @author rishabhsinghla
 *
 */
@Entity(name = "producttable")
@Table(name = "producttable")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int productId;

	@Column(name = "category")
	private String category;

	@Column(name = "name")
	private String productName;

	@Column(name = "description")
	private String description;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price")
	private int price;

	@Column(name = "date")
	private LocalDate addedDate;

}