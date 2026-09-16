package com.tca.service;

import com.tca.entity.Customer;
import com.tca.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> getById(Long id) {
        return customerRepository.findById(id);
    }
}
