package com.groceryapp.grocerymanagement.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {
    private Long orderId;
    private Long customerId;
    private List<OrderItemResponseDto> orderItems;
    private String orderDate;
    private Double totalPrice;
}
