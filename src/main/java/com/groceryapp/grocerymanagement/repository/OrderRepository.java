package com.groceryapp.grocerymanagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groceryapp.grocerymanagement.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
