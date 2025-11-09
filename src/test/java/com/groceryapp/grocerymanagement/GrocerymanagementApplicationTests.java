package com.groceryapp.grocerymanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import com.groceryapp.grocerymanagement.dto.CustomerDto;
import com.groceryapp.grocerymanagement.entity.Customer;
import com.groceryapp.grocerymanagement.service.CustomerService;
import com.groceryapp.grocerymanagement.mapper.CustomerMapper;

@SpringBootTest
class CustomerServiceTests {

    @Autowired
    private CustomerService customerService;

    @Test
    void testCreateCustomer() {
        Customer customer = new Customer(null,"John", "john@gmail.com", "Address", "98765", new ArrayList<>());
		CustomerDto customerDto = CustomerMapper.toDto(customer);
        Customer saved = CustomerMapper.toEntity(customerService.createCustomer(customerDto));
        assertNotNull(saved.getId());
    }
}