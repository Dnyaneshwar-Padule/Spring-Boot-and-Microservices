package com.tca.service;


import com.tca.entity.Customer;
import com.tca.entity.Order;
import com.tca.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("orderService")
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> getById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order save(Order order, Customer customer) {
        if (order == null || customer == null)
            throw new IllegalArgumentException("Parameters cannot be null.");
        order.setCustomer(customer);
        return orderRepository.save(order);
    }

    @Override
    public void delete(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public void softDelete(Long id) {
        orderRepository.softDelete(id);
    }

}
