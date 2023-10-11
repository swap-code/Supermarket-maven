package com.nagarro.superstore.dto.transformer;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.nagarro.superstore.dto.OrderDto;
import com.nagarro.superstore.entities.Order;

/**
 * Class for transforming Orders to OrdersDto using Functional Interface
 *
 * @author rishabhsinghla
 *
 */
@Component
public class OrderToOrderDto implements Function<Order, OrderDto> {

	@Override
	public OrderDto apply(Order order) {
		OrderDto orderDto = new OrderDto();
		orderDto.setProductId(order.getProductId());
		orderDto.setOrderId(order.getOrderId());
		orderDto.setOrderStatus(order.getOrderStatus());
		return orderDto;
	}

}
