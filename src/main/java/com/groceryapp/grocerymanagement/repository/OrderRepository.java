package com.groceryapp.grocerymanagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.groceryapp.grocerymanagement.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
