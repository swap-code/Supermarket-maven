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
import com.nagarro.superstore.services.AdminService;

/**
 * Service class for admin services
 * 
 * @author rishabhsinghla
 *
 */
@Service
public class AdminServiceImpl implements AdminService {

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

	@Autowired
	private Function<ProductDto, Product> productDtoToProduct;

	@Override
	public void addProduct(ProductDto productDto) {

		Product product = this.productDtoToProduct.apply(productDto);
		this.productRepoImpl.save(product);

	}

	@Override
	public void updateProduct(ProductDto productDto) {

		Product product = this.productDtoToProduct.apply(productDto);
		this.productRepoImpl.save(product);

	}

	@Override
	public void deleteProduct(Integer productId) {

		this.productRepoImpl.deleteById(productId);

	}

	@Override
	public ProductDto findAProduct(Integer productId) {

		Product product = this.productRepoImpl.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", " Id ", productId));
		ProductDto newProductDto = productToProductDto.apply(product);
		return newProductDto;

	}

	@Override
	public void markOutOfStock(Integer productId) {

		productRepoImpl.markOutOfStock(productId);

	}

	@Override
	public List<ProductDto> getLatestProducts() {

		List<Product> products = productRepoImpl.findAll();
		List<ProductDto> updatedProductDtos = products.stream().map((prod) -> productToProductDto.apply(prod))
				.collect(Collectors.toList());
		return updatedProductDtos;

	}

	@Override
	public List<OrderDto> showOrdersList() {

		List<Order> order = orderRepoImpl.showOrdersList();
		List<OrderDto> orderDtos = order.stream().map((prod) -> orderToOrderDto.apply(prod))
				.collect(Collectors.toList());
		return orderDtos;

	}

	@Override
	public void updateOrderStatus(OrderDto orderDto) {

		Order order = orderDtoToOrder.apply(orderDto);
		orderRepoImpl.updateOrderStatus(order);

	}

}
