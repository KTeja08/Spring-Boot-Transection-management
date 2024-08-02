package com.transactionmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.transactionmanagement.dto.CustomerDto;
import com.transactionmanagement.service.CustomerService;

@RestController
public class CustomerController {
    
    @Autowired
    CustomerService customerService;
    
    @PostMapping("/saveCustomer")
    public ResponseEntity<String> saveCustomer(@RequestBody CustomerDto customer) {
        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }

}