package com.tca.service;

import com.tca.entity.Customer;

import java.util.Optional;

public interface CustomerService {

    Customer save(Customer customer);

    Optional<Customer> getById(Long id);

    Optional<Customer> getByEmail(String email);
}
