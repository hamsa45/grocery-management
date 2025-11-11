package com.groceryapp.grocerymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroceryItemDto {
    private Long id;
    private String name;
    private String category;
    private Double price;
    private Integer quantity;
}
