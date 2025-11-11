package com.groceryapp.grocerymanagement.controller;

import com.groceryapp.grocerymanagement.service.GroceryItemService;
import com.groceryapp.grocerymanagement.dto.GroceryItemDto;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/grocery-items")
public class GroceryItemController {
    private final GroceryItemService groceryItemService;

    public GroceryItemController(GroceryItemService groceryItemService) {
        this.groceryItemService = groceryItemService;
    }

    @PostMapping
    public ResponseEntity<GroceryItemDto> addGroceryItem(@RequestBody GroceryItemDto groceryItemDto){
        // Implementation for adding a grocery item
        GroceryItemDto item = groceryItemService.addGroceryItem(groceryItemDto);
        return ResponseEntity.ok(item);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroceryItemDto> getGroceryItemById(@PathVariable Long id){
        // Implementation for getting a grocery item by ID
        GroceryItemDto item = groceryItemService.getGroceryItemById(id);
        return ResponseEntity.ok(item);
    }

    @GetMapping
    public ResponseEntity<List<GroceryItemDto>> getAllGroceryItems(){
        // Implementation for getting all grocery items
        List<GroceryItemDto> items = groceryItemService.getAllGroceryItems();
        return ResponseEntity.ok(items);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroceryItemDto> updateGroceryItem(@PathVariable Long id, @RequestBody GroceryItemDto groceryItemDto){
        // Implementation for updating a grocery item
        GroceryItemDto updatedItem = groceryItemService.updateGroceryItem(groceryItemDto);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroceryItemById(@PathVariable Long id){
        // Implementation for deleting a grocery item by ID
        groceryItemService.deleteGroceryItemById(id);
        return ResponseEntity.noContent().build();
    }
}
