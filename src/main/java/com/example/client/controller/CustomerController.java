package com.example.client.controller;

import com.example.client.globalexception.exceptionclass.DataNotFoundException;
import com.example.client.globalexception.exceptionclass.IdNotFoundException;
import com.example.client.model.dto.CustomerDto;
import com.example.client.model.entity.CustomerEntity;
import com.example.client.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private WebClient webClient;
    @PostMapping("/api/add")
     public ResponseEntity<?> addCustomerData(@RequestBody CustomerDto customerDto){
        CustomerEntity customerEntity = customerService.addCustomerDetails(customerDto);
        if(customerEntity == null){
            return new ResponseEntity<>("The customer data with the id "+customerDto.getId()+" is already present in database or the adharcard number is not registered in the adharcard service with the given user", HttpStatus.CONFLICT);
        }else if(customerEntity.isFlag() == true){
            return new ResponseEntity<>("The customer data "+customerDto+" has been registered in the database successfully and the loan amount : "+customerDto.getLoan_amount()+" has been approved ", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Sorry, Your loan amount has been rejected for the loan amount being greater then 300000 lakh", HttpStatus.OK);
        }
    }
     @GetMapping("/api/get/{id}")
     public ResponseEntity<?> getCustomerData(@PathVariable int id){
         CustomerDto customerDto = customerService.getCustomerDetails(id);
         if(customerDto == null){
             throw new IdNotFoundException("The id is not present in the Loan Management System");
         }else{
             return new ResponseEntity<>("The data with the id "+id+" present in customer database is : "+customerDto, HttpStatus.OK);
         }
     }
     @PutMapping("/api/update")
     public ResponseEntity<?> updateCustomerData(@RequestBody CustomerDto customerDto){
         CustomerEntity customerEntity = customerService.updateCustomerDetails(customerDto);
         if(customerEntity == null){
             throw new DataNotFoundException("There is no data present in database");
         }
         return new ResponseEntity<>("The updated data is : "+customerEntity, HttpStatus.OK);
     }
     @DeleteMapping("/api/delete/{id}")
     public void deleteCustomerData(@PathVariable int id){
         customerService.deleteCustomerDetails(id);
     }
     @GetMapping("/api/get")
     public ResponseEntity<?> getAllCustomerData(){
         List<CustomerDto> list = customerService.getAllCustomerDetails();
         if(list.size() != 0){
             return new ResponseEntity<>(list, HttpStatus.OK);
         }
         throw new DataNotFoundException("There in no data present in Loan Management System database");
     }
}
