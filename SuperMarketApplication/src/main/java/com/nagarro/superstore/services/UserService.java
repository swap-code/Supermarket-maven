package com.nagarro.superstore.services;

import java.util.List;

import com.nagarro.superstore.dto.OrderDto;
import com.nagarro.superstore.dto.ProductDto;

/**
 * Interface for services for User
 *
 * @author rishabhsinghla
 *
 */
public interface UserService {

	ProductDto findAProduct(Integer productId);

	List<ProductDto> getLatestProducts();

	List<ProductDto> getCategoryWiseProducts();

	List<ProductDto> searchByCategory(String category);

	List<ProductDto> searchByItemName(String name);

	List<ProductDto> searchByDescription(String description);

	ProductDto searchByBarCode(int barCode);

	OrderDto orderProduct(int productId);

	OrderDto trackOrderStatus(OrderDto orderDto);

}
