package com.tca.service;

import com.tca.entity.Customer;
import com.tca.entity.Order;
import com.tca.entity.OrderItem;
import com.tca.entity.OrderStatus;
import com.tca.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        order.setOrderStatus(OrderStatus.ORDERED);
        order.setCustomer(customer);
        order.setOrderDate(LocalDate.now());
        
        for(OrderItem orderItem : cartItems){
            order.addOrderItem(orderItem);
        }

        orderRepository.save(order);
        return order;
    }

    @Override
    public Optional<Order> getById(Long id) {
        return orderRepository.findById(id);
    }
}
