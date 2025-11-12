package com.groceryapp.grocerymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponseDto {
    private Long groceryItemId;
    private String itemName;
    private Integer quantity;
    private Double priceAtOrder;
    private Double totalItemPrice;
}
