package com.groceryapp.grocerymanagement.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Order order;

    @ManyToOne(optional = false)
    private GroceryItem groceryItem;

    private Integer quantity;
    private Double priceAtOrder;


    public void setOrder(Order order) {
        this.order = order;
    }
}
