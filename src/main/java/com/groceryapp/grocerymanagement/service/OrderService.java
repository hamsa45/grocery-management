package com.groceryapp.grocerymanagement.service;

import com.groceryapp.grocerymanagement.dto.OrderRequestDto;
import com.groceryapp.grocerymanagement.dto.OrderResponseDto;
import com.groceryapp.grocerymanagement.entity.Order;

public interface OrderService {
    OrderResponseDto createOrder(OrderRequestDto orderRequest);
    OrderResponseDto getOrderById(Long id);

}
