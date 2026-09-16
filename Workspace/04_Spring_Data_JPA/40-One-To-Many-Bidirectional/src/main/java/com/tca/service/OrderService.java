package com.tca.service;

import com.tca.entity.Customer;
import com.tca.entity.Order;

import java.util.Optional;

public interface OrderService {

    public Optional<Order> getById(Long id);

    public Order save(Order order, Customer customer);

    public void delete(Order order);

    public void softDelete(Long id);
}

