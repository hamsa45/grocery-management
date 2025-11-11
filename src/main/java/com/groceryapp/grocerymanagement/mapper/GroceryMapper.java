package com.groceryapp.grocerymanagement.mapper;

import com.groceryapp.grocerymanagement.dto.GroceryItemDto;
import com.groceryapp.grocerymanagement.entity.GroceryItem;

public class GroceryMapper {

    public static GroceryItem toEntity(GroceryItemDto groceryItemDto){
        if(groceryItemDto == null){
            return null;
        }
        GroceryItem groceryItem = new GroceryItem();
        groceryItem.setId(groceryItemDto.getId());
        groceryItem.setName(groceryItemDto.getName());
        groceryItem.setCategory(groceryItemDto.getCategory());
        groceryItem.setPrice(groceryItemDto.getPrice());
        groceryItem.setQuantity(groceryItemDto.getQuantity());
        return groceryItem;
    }

    public static GroceryItemDto toDto(GroceryItem groceryItem){
        if(groceryItem == null){
            return null;
        }
        GroceryItemDto groceryItemDto = new GroceryItemDto();
        groceryItemDto.setId(groceryItem.getId());
        groceryItemDto.setName(groceryItem.getName());
        groceryItemDto.setCategory(groceryItem.getCategory());
        groceryItemDto.setPrice(groceryItem.getPrice());
        groceryItemDto.setQuantity(groceryItem.getQuantity());
        return groceryItemDto;
    }
}
