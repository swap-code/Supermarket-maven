package com.nagarro.superstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.superstore.dto.OrderDto;
import com.nagarro.superstore.dto.ProductDto;
import com.nagarro.superstore.services.UserService;

/**
 * Class for operations to be performed by user
 *
 * @author rishabhsinghla
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/search/{productId}")
	public ResponseEntity<ProductDto> findAProduct(@PathVariable int productId) {
		ProductDto foundProductDto = this.userService.findAProduct(productId);
		return new ResponseEntity<ProductDto>(foundProductDto, HttpStatus.OK);
	}

	@GetMapping("/latest")
	public ResponseEntity<List<ProductDto>> getLatestProducts() {
		List<ProductDto> listOfProducts = this.userService.getLatestProducts();
		return ResponseEntity.ok(listOfProducts);
	}

	@GetMapping("/category")
	public ResponseEntity<List<ProductDto>> getCategoryWiseProducts() {
		List<ProductDto> listOfProducts = this.userService.getCategoryWiseProducts();
		return ResponseEntity.ok(listOfProducts);
	}

	@GetMapping("/search/cat/{category}")
	public ResponseEntity<List<ProductDto>> searchByCategory(@PathVariable String category) {
		List<ProductDto> foundProductDto = this.userService.searchByCategory(category);
		return new ResponseEntity<List<ProductDto>>(foundProductDto, HttpStatus.OK);
	}

	@GetMapping("/search/name/{name}")
	public ResponseEntity<List<ProductDto>> searchByItemName(@PathVariable String name) {
		List<ProductDto> foundProductDto = this.userService.searchByItemName(name);
		return new ResponseEntity<List<ProductDto>>(foundProductDto, HttpStatus.OK);
	}

	@GetMapping("/search/id/{productId}")
	public ResponseEntity<ProductDto> searchByBarCode(@PathVariable int productId) {
		ProductDto foundProductDto = this.userService.searchByBarCode(productId);
		return new ResponseEntity<ProductDto>(foundProductDto, HttpStatus.OK);
	}

	@GetMapping("/search/desc/{description}")
	public ResponseEntity<List<ProductDto>> searchByDescription(@PathVariable String description) {
		List<ProductDto> foundProductDto = this.userService.searchByDescription(description);
		return new ResponseEntity<List<ProductDto>>(foundProductDto, HttpStatus.OK);
	}

	@PostMapping("/order")
	public ResponseEntity<OrderDto> orderProduct(@PathVariable int productId) {
		OrderDto orderDto = this.userService.orderProduct(productId);
		return new ResponseEntity<OrderDto>(orderDto, HttpStatus.OK);
	}

	@GetMapping("/track")
	public ResponseEntity<OrderDto> trackOrderStatus(@RequestBody OrderDto orderDto) {
		OrderDto orderDtoFound = this.userService.trackOrderStatus(orderDto);
		return new ResponseEntity<OrderDto>(orderDtoFound, HttpStatus.OK);
	}

}
