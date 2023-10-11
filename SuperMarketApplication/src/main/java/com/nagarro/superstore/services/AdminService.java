package com.nagarro.superstore.services;

import java.util.List;

import com.nagarro.superstore.dto.OrderDto;
import com.nagarro.superstore.dto.ProductDto;

/**
 * Interface for service for admin
 *
 * @author rishabhsinghla
 *
 */
public interface AdminService {

	void addProduct(ProductDto productDto);

	void updateProduct(ProductDto productDto);

	void deleteProduct(Integer productId);

	ProductDto findAProduct(Integer productId);

	void markOutOfStock(Integer productId);

	List<ProductDto> getLatestProducts();

	List<OrderDto> showOrdersList();

	void updateOrderStatus(OrderDto orderDto);

}
