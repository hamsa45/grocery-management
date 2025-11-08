    package com.groceryapp.grocerymanagement.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "grocery_items")
public class GroceryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private Double price;
    private Integer quantity;

    @OneToMany(mappedBy = "groceryItem")
    private List<OrderItem> orderItems = new ArrayList<>();
}
