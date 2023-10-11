package com.nagarro.superstore.services.impl;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.superstore.dto.OrderDto;
import com.nagarro.superstore.dto.ProductDto;
import com.nagarro.superstore.entities.Order;
import com.nagarro.superstore.entities.Product;
import com.nagarro.superstore.exceptions.ResourceNotFoundException;
import com.nagarro.superstore.repositories.OrderRepo;
import com.nagarro.superstore.repositories.ProductRepo;
import com.nagarro.superstore.services.UserService;

/**
 * Service class for User Tasks
 * 
 * @author rishabhsinghla
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private OrderRepo orderRepoImpl;

	@Autowired
	private ProductRepo productRepoImpl;

	@Autowired
	private Function<Order, OrderDto> orderToOrderDto;

	@Autowired
	private Function<Product, ProductDto> productToProductDto;

	@Autowired
	private Function<OrderDto, Order> orderDtoToOrder;

	@Override
	public ProductDto findAProduct(Integer productId) {

		Product product = this.productRepoImpl.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", " Id ", productId));
		ProductDto newProductDto = productToProductDto.apply(product);
		return newProductDto;

	}

	@Override
	public List<ProductDto> getLatestProducts() {

		List<Product> products = this.productRepoImpl.findAll();
		List<ProductDto> proDtos = products.stream().map((prod) -> productToProductDto.apply(prod))
				.collect(Collectors.toList());
		return proDtos;

	}

	@Override
	public List<ProductDto> getCategoryWiseProducts() {

		List<Product> products = productRepoImpl.getCategoryWiseProducts();
		List<ProductDto> proDtos = products.stream().map((prod) -> productToProductDto.apply(prod))
				.collect(Collectors.toList());
		return proDtos;

	}

	@Override
	public List<ProductDto> searchByCategory(String category) {

		List<Product> products = productRepoImpl.searchByCategory(category);
		List<ProductDto> proDtos = products.stream().map((prod) -> productToProductDto.apply(prod))
				.collect(Collectors.toList());
		return proDtos;

	}

	@Override
	public List<ProductDto> searchByItemName(String name) {

		List<Product> products = productRepoImpl.searchByItemName(name);
		List<ProductDto> proDtos = products.stream().map((prod) -> productToProductDto.apply(prod))
				.collect(Collectors.toList());
		return proDtos;

	}

	@Override
	public List<ProductDto> searchByDescription(String description) {

		List<Product> products = productRepoImpl.searchByDescription(description);
		List<ProductDto> proDtos = products.stream().map((prod) -> productToProductDto.apply(prod))
				.collect(Collectors.toList());
		return proDtos;

	}

	@Override
	public ProductDto searchByBarCode(int barCode) {

		Product product = productRepoImpl.searchByBarCode(barCode);
		ProductDto newProductDto = productToProductDto.apply(product);
		return newProductDto;

	}

	@Override
	public OrderDto orderProduct(int productId) {

		Order newOrder = orderRepoImpl.orderProduct(productId);
		OrderDto orderDto = orderToOrderDto.apply(newOrder);
		return orderDto;

	}

	@Override
	public OrderDto trackOrderStatus(OrderDto orderDto) {

		Order order = orderDtoToOrder.apply(orderDto);
		Order updatedOrder = orderRepoImpl.trackOrderStatus(order.getOrderId());
		OrderDto updatedOrderDto = orderToOrderDto.apply(updatedOrder);
		return updatedOrderDto;

	}
}
