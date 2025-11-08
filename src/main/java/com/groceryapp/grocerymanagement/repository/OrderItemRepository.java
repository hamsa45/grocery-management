package com.groceryapp.grocerymanagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.groceryapp.grocerymanagement.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
