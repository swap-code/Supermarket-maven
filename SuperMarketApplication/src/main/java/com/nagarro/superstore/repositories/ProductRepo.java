package com.nagarro.superstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.superstore.entities.Product;

/**
 * Repository interface for admin operations on and order
 *
 * @author rishabhsinghla
 *
 */
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
