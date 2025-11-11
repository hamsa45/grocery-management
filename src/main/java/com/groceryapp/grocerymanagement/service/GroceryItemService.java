package com.groceryapp.grocerymanagement.service;

import java.util.List;

import com.groceryapp.grocerymanagement.dto.GroceryItemDto;
import com.groceryapp.grocerymanagement.repository.GroceryItemRepository;

public interface GroceryItemService {
    GroceryItemDto addGroceryItem(GroceryItemDto groceryItemDto);
    GroceryItemDto getGroceryItemById(Long id);
    List<GroceryItemDto> getAllGroceryItems();
    GroceryItemDto updateGroceryItem(GroceryItemDto groceryItemDto);
    void deleteGroceryItemById(Long id);
}
