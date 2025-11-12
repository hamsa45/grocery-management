package com.groceryapp.grocerymanagement.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.groceryapp.grocerymanagement.service.OrderService;
import com.groceryapp.grocerymanagement.dto.OrderRequestDto;
import com.groceryapp.grocerymanagement.dto.OrderResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        OrderResponseDto createdOrder = orderService.createOrder(orderRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    public ResponseEntity<OrderResponseDto> getOrderById(Long id) {
        OrderResponseDto order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }
}
