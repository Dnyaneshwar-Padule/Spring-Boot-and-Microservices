package com.tca.service;

import com.tca.entity.Order;

import java.util.Optional;

public interface OrderService {

    public Optional<Order> getById(Long id);

    public Order updateOrderStatus(Order order);
}
