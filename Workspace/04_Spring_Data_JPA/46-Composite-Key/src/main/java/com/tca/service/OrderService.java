package com.tca.service;

import com.tca.entity.Order;
import com.tca.entity.Customer;
import com.tca.entity.OrderItem;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order placeOrder(Customer customer, List<OrderItem> cartItems);

    Optional<Order> getById(Long id);
}
