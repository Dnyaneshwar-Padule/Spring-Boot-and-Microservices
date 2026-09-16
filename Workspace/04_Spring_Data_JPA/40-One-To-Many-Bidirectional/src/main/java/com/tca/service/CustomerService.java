package com.tca.service;

import com.tca.entity.Customer;

import java.util.Optional;

public interface CustomerService {

    public Customer save(Customer customer);

    public Optional<Customer> getById(Long id);
}
