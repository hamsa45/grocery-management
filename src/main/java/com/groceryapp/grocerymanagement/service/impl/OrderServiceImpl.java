package com.groceryapp.grocerymanagement.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groceryapp.grocerymanagement.service.OrderService;
import com.groceryapp.grocerymanagement.dto.OrderRequestDto;
import com.groceryapp.grocerymanagement.dto.OrderResponseDto;
import com.groceryapp.grocerymanagement.entity.Order;
import com.groceryapp.grocerymanagement.entity.OrderItem;
import com.groceryapp.grocerymanagement.mapper.GroceryMapper;
import com.groceryapp.grocerymanagement.repository.CustomerRepository;
import com.groceryapp.grocerymanagement.repository.OrderRepository;
import com.groceryapp.grocerymanagement.repository.GroceryItemRepository;
import com.groceryapp.grocerymanagement.dto.OrderItemRequestDto;
import com.groceryapp.grocerymanagement.dto.OrderItemResponseDto;
import com.groceryapp.grocerymanagement.entity.Customer;
import com.groceryapp.grocerymanagement.entity.GroceryItem;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final GroceryItemRepository groceryItemRepository;
    
    public OrderServiceImpl(OrderRepository orderRepository,
                            CustomerRepository customerRepository,
                            GroceryItemRepository groceryItemRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.groceryItemRepository = groceryItemRepository;
    }
    
    @Override
    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
        // Implementation for creating an order
        OrderResponseDto responseDto = new OrderResponseDto();
        Customer customer = customerRepository.findById(orderRequestDto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + orderRequestDto.getCustomerId()));
        responseDto.setCustomerId(customer.getId());
        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderDate(LocalDateTime.now());

        Double totalPrice = 0.0;

        //List<OrderItemRequestDto> orderItems = orderRequestDto.getOrderItems();
        for (OrderItemRequestDto orderItemRequestDto : orderRequestDto.getOrderItems()) {
            //find if the item exists, if exists required quantity is available
            //OrderItemResponseDto orderItemResponseDto = new OrderItemResponseDto();
            GroceryItem item = groceryItemRepository
                .findById(orderItemRequestDto.getGroceryItemId())
                .orElseThrow(() -> new RuntimeException("Grocery item not found with id: " + orderItemRequestDto.getGroceryItemId()));

            if (item.getQuantity() < orderItemRequestDto.getQuantity()) {
                throw new RuntimeException("Insufficient quantity for item id: " + orderItemRequestDto.getGroceryItemId());
            }
            
            // Deduct the quantity from inventory
            item.setQuantity(item.getQuantity() - orderItemRequestDto.getQuantity());
            
            totalPrice += item.getPrice() * orderItemRequestDto.getQuantity();

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setGroceryItem(item);
            orderItem.setQuantity(orderItemRequestDto.getQuantity());
            orderItem.setPriceAtOrder(item.getPrice());
            order.addItem(orderItem);
        }

        order.setTotalPrice(totalPrice);

        Order savedOrder = orderRepository.save(order);

        return mapToOrderResponseDto(savedOrder);
    }

    private OrderResponseDto mapToOrderResponseDto(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setOrderId(order.getId());
        dto.setCustomerId(order.getCustomer().getId());
        dto.setOrderDate(order.getOrderDate().toString());
        dto.setTotalPrice(order.getTotalPrice());

        List<OrderItemResponseDto> itemDtos = new ArrayList<>();
        for (OrderItem item : order.getItems()) {
            OrderItemResponseDto itemDto = new OrderItemResponseDto();
            itemDto.setGroceryItemId(item.getGroceryItem().getId());
            itemDto.setQuantity(item.getQuantity());
            itemDto.setPriceAtOrder(item.getPriceAtOrder());
            Double totalItemPrice = item.getPriceAtOrder() * item.getQuantity();
            itemDto.setTotalItemPrice(totalItemPrice);
            itemDto.setItemName(item.getGroceryItem().getName());
            itemDtos.add(itemDto);
        }
        dto.setOrderItems(itemDtos);
        return dto;
    }

    @Override
    public OrderResponseDto getOrderById(Long id) {
        // TODO Auto-generated method stub
        Order order = orderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found with id: " + id)
            );

        return mapToOrderResponseDto(order);
    }
    
    @Override
    public List<OrderResponseDto> getAllOrders() {
        // TODO Auto-generated method stub
        List<Order> orders = orderRepository.findAll();
        List<OrderResponseDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            orderDtos.add(mapToOrderResponseDto(order));
        }
        return orderDtos;
    }

    @Override
    public void deleteOrderById(Long id) {
        // TODO Auto-generated method stub
        Order existingOrder = orderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found with id: " + id)
            );
        orderRepository.delete(existingOrder);
    }

    @Override
    public OrderResponseDto updateOrder(Long id, OrderRequestDto orderRequest) {
        // TODO Auto-generated method stub
        Order existingOrder = orderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found with id: " + id)
            );

        // For simplicity, only updating order items here
        existingOrder.getItems().clear();
        Double totalPrice = 0.0;

        for (OrderItemRequestDto orderItemRequestDto : orderRequest.getOrderItems()) {
            GroceryItem item = groceryItemRepository
                .findById(orderItemRequestDto.getGroceryItemId())
                .orElseThrow(() -> new RuntimeException("Grocery item not found with id: " + orderItemRequestDto.getGroceryItemId()));

            if (item.getQuantity() < orderItemRequestDto.getQuantity()) {
                throw new RuntimeException("Insufficient quantity for item id: " + orderItemRequestDto.getGroceryItemId());
            }

            // Deduct the quantity from inventory
            item.setQuantity(item.getQuantity() - orderItemRequestDto.getQuantity());

            totalPrice += item.getPrice() * orderItemRequestDto.getQuantity();

            OrderItem orderItem = new OrderItem();
            orderItem.setGroceryItem(item);
            orderItem.setQuantity(orderItemRequestDto.getQuantity());
            orderItem.setPriceAtOrder(item.getPrice());
            existingOrder.addItem(orderItem);
        }

        existingOrder.setTotalPrice(totalPrice);

        Order updatedOrder = orderRepository.save(existingOrder);

        return mapToOrderResponseDto(updatedOrder);
    }
}
