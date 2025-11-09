package com.groceryapp.grocerymanagement.service;

import java.util.List;

import com.groceryapp.grocerymanagement.dto.CustomerDto;
import com.groceryapp.grocerymanagement.entity.Customer;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);
    CustomerDto getCustomerById(Long id);
    List<CustomerDto> getAllCustomers();
    CustomerDto updateCustomer(Long id, CustomerDto customerDto);
    void deleteCustomer(Long id);
}
