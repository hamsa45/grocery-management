package com.groceryapp.grocerymanagement.service;

import com.groceryapp.grocerymanagement.dto.OrderRequestDto;
import com.groceryapp.grocerymanagement.dto.OrderResponseDto;
import com.groceryapp.grocerymanagement.entity.Order;
import java.util.List;

public interface OrderService {
    OrderResponseDto createOrder(OrderRequestDto orderRequest);
    OrderResponseDto updateOrder(Long id, OrderRequestDto orderRequest);
    OrderResponseDto getOrderById(Long id);
    List<OrderResponseDto> getAllOrders();
    void deleteOrderById(Long id);
}
