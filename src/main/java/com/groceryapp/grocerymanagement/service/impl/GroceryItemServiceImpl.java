package com.groceryapp.grocerymanagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.groceryapp.grocerymanagement.dto.GroceryItemDto;
import com.groceryapp.grocerymanagement.entity.GroceryItem;
import com.groceryapp.grocerymanagement.mapper.GroceryMapper;
import com.groceryapp.grocerymanagement.repository.GroceryItemRepository;

@Service
public class GroceryItemServiceImpl {
    private GroceryItemRepository groceryItemRepository;

    public GroceryItemServiceImpl(GroceryItemRepository groceryItemRepository){
        this.groceryItemRepository = groceryItemRepository;
    }

    public GroceryItemDto addGroceryItem(GroceryItemDto groceryItemDto){
        GroceryItem groceryItem = groceryItemRepository.save(GroceryMapper.toEntity(groceryItemDto));
        return GroceryMapper.toDto(groceryItem);
    }

    public GroceryItemDto getGroceryItemById(Long id){
        GroceryItem groceryItem = groceryItemRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Grocery item not found with id: " + id));
        return GroceryMapper.toDto(groceryItem);
    }

    public GroceryItemDto updateGroceryItem(GroceryItemDto groceryItemDto){
        GroceryItem existingGroceryItem = groceryItemRepository.findById(groceryItemDto.getId())
            .orElseThrow(() -> new RuntimeException("Grocery item not found with id: " + groceryItemDto.getId()));
        existingGroceryItem.setName(groceryItemDto.getName());
        existingGroceryItem.setCategory(groceryItemDto.getCategory());
        existingGroceryItem.setPrice(groceryItemDto.getPrice());
        existingGroceryItem.setQuantity(groceryItemDto.getQuantity());
        GroceryItem updatedGroceryItem = groceryItemRepository.save(existingGroceryItem);
        return GroceryMapper.toDto(updatedGroceryItem);
    }

    public void deleteGroceryItemById(Long id){
        groceryItemRepository.deleteById(id);
    }

    public List<GroceryItemDto> getAllGroceryItems(){
        List<GroceryItem> groceryItems = groceryItemRepository.findAll();
        List<GroceryItemDto> groceryItemDtos = groceryItems.stream()
            .map(GroceryMapper::toDto)
            .toList();
        return groceryItemDtos;
    }
}
