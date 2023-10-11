package com.nagarro.superstore.entities.transformer;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.nagarro.superstore.dto.ProductDto;
import com.nagarro.superstore.entities.Product;

/**
 * Class for transforming ProductDto to Product using Functional Interface
 *
 * @author rishabhsinghla
 *
 */
@Component
public class ProductDtoToProduct implements Function<ProductDto, Product> {

	@Override
	public Product apply(ProductDto productDto) {
		Product product = new Product();
		product.setPrice(productDto.getPrice());
		product.setCategory(productDto.getCategory());
		product.setDescription(productDto.getDescription());
		product.setProductId(productDto.getProductId());
		product.setProductName(productDto.getProductName());
		product.setQuantity(productDto.getQuantity());
		product.setAddedDate(productDto.getAddedDate());
		return product;
	}
}
