package com.transactionmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transactionmanagement.dto.CustomerDto;
import com.transactionmanagement.entities.Address;
import com.transactionmanagement.entities.Customer;
import com.transactionmanagement.repositories.AddressRepository;
import com.transactionmanagement.repositories.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AddressRepository addressRepository;

    @Transactional
    public String saveCustomer(CustomerDto customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getCustomerName());
        customer.setUrl(customerDTO.getWebsite());
        Customer dbCustomer = customerRepository.save(customer);
        
        Address address =new Address();
        address.setArea(customerDTO.getArea());
        address.setCity(customerDTO.getCity());
        address.setCountry(customerDTO.getCountry());
        address.setPincode(customerDTO.getPincode());
        address.setCustomer(dbCustomer);
        addressRepository.save(address);

        return "Customer saved successfully: " + dbCustomer.getId();
    }

}