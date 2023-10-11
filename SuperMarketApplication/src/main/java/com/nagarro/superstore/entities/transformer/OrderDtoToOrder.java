package com.nagarro.superstore.entities.transformer;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.nagarro.superstore.dto.OrderDto;
import com.nagarro.superstore.entities.Order;

/**
 * Class for transforming OrdersDto to Orders using Functional Interface
 *
 * @author rishabhsinghla
 *
 */
@Component
public class OrderDtoToOrder implements Function<OrderDto, Order> {

	@Override
	public Order apply(OrderDto orderDto) {
		Order order = new Order();
		order.setProductId(orderDto.getProductId());
		order.setOrderId(orderDto.getOrderId());
		order.setOrderStatus(orderDto.getOrderStatus());
		return order;
	}
}
