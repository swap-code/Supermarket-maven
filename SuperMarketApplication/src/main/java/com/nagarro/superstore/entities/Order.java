package com.nagarro.superstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nagarro.superstore.utilities.OrderStatus;

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
@Entity(name = "ordertable")
@Table(name = "ordertable")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Order {

	@Id
	@Column(name = "id")
	private String orderId;

	@Column(name = "status")
	private OrderStatus orderStatus;

	@Column(name = "prod_id")
	private int productId;

}
