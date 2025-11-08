package com.groceryapp.grocerymanagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.groceryapp.grocerymanagement.entity.GroceryItem;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {

}
