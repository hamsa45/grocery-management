package com.groceryapp.grocerymanagement.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {
    private Long customerId;
    private List<OrderItemRequestDto> orderItems;
}
