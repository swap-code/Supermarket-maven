package com.nagarro.superstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.superstore.dto.OrderDto;
import com.nagarro.superstore.dto.ProductDto;
import com.nagarro.superstore.services.AdminService;
import com.nagarro.superstore.utilities.ApiResponse;

/**
 * Class for operations to be performed by admin
 *
 * @author rishabhsinghla
 *
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductDto productDto) {
		this.adminService.addProduct(productDto);
		return new ResponseEntity<ApiResponse>(new ApiResponse("product is added successfully !!", true),
				HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<ApiResponse> updateProduct(@RequestBody ProductDto productDto) {
		this.adminService.updateProduct(productDto);
		return new ResponseEntity<ApiResponse>(new ApiResponse("product is updated successfully !!", true),
				HttpStatus.OK);
	}

	@DeleteMapping("/{productId}")
	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable int productId) {
		this.adminService.deleteProduct(productId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("product is deleted successfully !!", true),
				HttpStatus.OK);
	}

	@GetMapping("/{productId}")
	public ResponseEntity<ProductDto> findAProduct(@PathVariable int productId) {
		ProductDto foundProductDto = this.adminService.findAProduct(productId);
		return new ResponseEntity<ProductDto>(foundProductDto, HttpStatus.OK);
	}

	@GetMapping("/latest")
	public ResponseEntity<List<ProductDto>> getLatestProducts() {
		List<ProductDto> listOfProducts = this.adminService.getLatestProducts();
		return ResponseEntity.ok(listOfProducts);
	}

	@GetMapping("/orders")
	public ResponseEntity<List<OrderDto>> showOrdersList() {
		List<OrderDto> ordersList = this.adminService.showOrdersList();
		return ResponseEntity.ok(ordersList);
	}

	@PutMapping("/mark/{productId}")
	public ResponseEntity<ApiResponse> markOutOfStock(@PathVariable int productId) {
		this.adminService.markOutOfStock(productId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("order marked OUT OF STOCK successfully !!", true),
				HttpStatus.OK);
	}

	@PutMapping("/updatestatus")
	public ResponseEntity<ApiResponse> updateOrderStatus(@RequestBody OrderDto orderDto) {
		this.adminService.updateOrderStatus(orderDto);
		return new ResponseEntity<ApiResponse>(new ApiResponse("order status updated successfully !!", true),
				HttpStatus.OK);
	}

}
