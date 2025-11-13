package com.groceryapp.grocerymanagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groceryapp.grocerymanagement.entity.GroceryItem;

@Repository
public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {

}
