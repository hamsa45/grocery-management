package com.groceryapp.grocerymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groceryapp.grocerymanagement.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
