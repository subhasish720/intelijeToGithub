package com.example.client.service;

import com.example.client.model.dto.CustomerDto;
import com.example.client.model.entity.CustomerEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    public CustomerEntity addCustomerDetails(CustomerDto customerDto);
    public CustomerDto getCustomerDetails(int id);
    public void deleteCustomerDetails(int id);
    public List<CustomerDto> getAllCustomerDetails();
    public CustomerEntity updateCustomerDetails(CustomerDto customerDto);
}
