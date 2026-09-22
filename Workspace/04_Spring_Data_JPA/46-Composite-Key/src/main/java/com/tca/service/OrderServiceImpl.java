package com.tca.service;

import com.tca.entity.Customer;
import com.tca.entity.Order;
import com.tca.entity.OrderItem;
import com.tca.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("orderService")
public class OrderServiceImpl  implements  OrderService{

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order placeOrder(Customer customer, List<OrderItem> cartItems) {
        Order order = new Order();
        order.setOrderItems(cartItems);
        order.setCustomer(customer);
        orderRepository.save(order);
        return order;
    }

    @Override
    public Optional<Order> getById(Long id) {
        return orderRepository.findById(id);
    }
}
