package com.nagarro.superstore.dto.transformer;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.nagarro.superstore.dto.ProductDto;
import com.nagarro.superstore.entities.Product;

/**
 * Class for transforming Product to ProductDto using Functional Interface
 *
 * @author rishabhsinghla
 *
 */
@Component
public class ProductToProductDto implements Function<Product, ProductDto> {

	@Override
	public ProductDto apply(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setPrice(product.getPrice());
		productDto.setCategory(product.getCategory());
		productDto.setDescription(product.getDescription());
		productDto.setProductId(product.getProductId());
		productDto.setProductName(product.getProductName());
		productDto.setQuantity(product.getQuantity());
		productDto.setAddedDate(product.getAddedDate());
		return productDto;
	}
}
