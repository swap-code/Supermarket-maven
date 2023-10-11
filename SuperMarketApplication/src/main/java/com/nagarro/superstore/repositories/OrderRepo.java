package com.nagarro.superstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.superstore.entities.Order;

/**
 * Repository interface for admin operations on product and order
 *
 * @author rishabhsinghla
 *
 */
public interface OrderRepo extends JpaRepository<Order, String> {

}
