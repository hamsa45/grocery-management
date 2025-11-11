package com.groceryapp.grocerymanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groceryapp.grocerymanagement.dto.CustomerDto;
import com.groceryapp.grocerymanagement.entity.Customer;
import com.groceryapp.grocerymanagement.mapper.CustomerMapper;
import com.groceryapp.grocerymanagement.service.CustomerService;
import com.groceryapp.grocerymanagement.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.toEntity(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.toDto(savedCustomer);
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        // TODO Auto-generated method stub
        Customer customer = customerRepository.findById(id)
            .orElseThrow(
                () -> new RuntimeException("Customer not found with id: " + id)
            );
            return CustomerMapper.toDto(customer);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        // TODO Auto-generated method stub
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customers) {
            customerDtos.add(CustomerMapper.toDto(customer));
        }
        return customerDtos;
    }

    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {
        // TODO Auto-generated method stub
        Customer existingCustomer = customerRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id)
            );

        existingCustomer.setName(customerDto.getName());
        existingCustomer.setEmail(customerDto.getEmail());
        existingCustomer.setAddress(customerDto.getAddress());
        existingCustomer.setPhoneNumber(customerDto.getPhoneNumber());

        CustomerDto updatedCustomerDto = CustomerMapper.toDto(
            customerRepository.save(existingCustomer)
        );
        return updatedCustomerDto;
    }

    @Override
    public void deleteCustomer(Long id) {
        // TODO Auto-generated method stub
        Customer existingCustomer = customerRepository.findById(id)
            .orElseThrow(
                () -> new RuntimeException("Customer not found with id: " + id)
            );
        customerRepository.deleteById(id);
    }
}
