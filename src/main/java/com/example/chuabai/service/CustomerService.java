package com.example.chuabai.service;

import com.example.chuabai.CustomerRequest;
import com.example.chuabai.CustomerSpec;
import com.example.chuabai.PaginateRequest;
import com.example.chuabai.model.Customer;
import com.example.chuabai.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Page<Customer> findAll(PaginateRequest paginateRequest, CustomerRequest customerRequest) {
        return customerRepository.findAll(
                new CustomerSpec(customerRequest),
                PageRequest.of(paginateRequest.getPage(), paginateRequest.getSize())
        );
    }

    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }


    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }


    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
}
