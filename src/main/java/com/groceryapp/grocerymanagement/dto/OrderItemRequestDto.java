package com.groceryapp.grocerymanagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemRequestDto {
    private Long groceryItemById;
    private Integer quantity;
}
