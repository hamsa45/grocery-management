package com.groceryapp.grocerymanagement.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.groceryapp.grocerymanagement.service.CustomerService;
import com.groceryapp.grocerymanagement.dto.CustomerDto;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //add customer-related endpoints here
    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customerService.createCustomer(customerDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") Long id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable Long id){   
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long id, @RequestBody CustomerDto customerDetailsCustomerDto){
        CustomerDto updatedCustomer = customerService.updateCustomer(id, customerDetailsCustomerDto);
        return ResponseEntity.ok(updatedCustomer);
    }
}