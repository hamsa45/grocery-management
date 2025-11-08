package com.groceryapp.grocerymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.groceryapp.grocerymanagement.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
