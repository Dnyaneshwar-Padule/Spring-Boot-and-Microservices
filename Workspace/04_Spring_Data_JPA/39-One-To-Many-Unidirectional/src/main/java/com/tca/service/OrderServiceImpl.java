package com.tca.service;

import com.tca.entity.Order;
import com.tca.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("orderService")
public class OrderServiceImpl implements OrderService{

    /* Spring automatically initializes orderService with object of orderRepository */
    private final OrderRepository  orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> getById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order updateOrderStatus(Order order) {
        return orderRepository.save(order);
    }
}
