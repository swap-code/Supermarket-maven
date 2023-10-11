package com.nagarro.superstore.dto;

import com.nagarro.superstore.utilities.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * OrdersDto class for data transfer between DAO and service layers
 *
 * @author rishabhsinghla
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class OrderDto {

	private String orderId;

	private OrderStatus orderStatus;

	private int productId;

}
