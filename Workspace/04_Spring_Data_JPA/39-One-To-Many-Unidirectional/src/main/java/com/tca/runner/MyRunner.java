package com.tca.runner;

import com.tca.entity.Customer;
import com.tca.entity.Order;
import com.tca.entity.OrderStatus;
import com.tca.repository.OrderRepository;
import com.tca.service.CustomerService;
import com.tca.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MyRunner implements ApplicationRunner {

    private final CustomerService customerService;

    private final OrderService orderService;

    public MyRunner(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }


    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
//        Customer customer = new Customer();
//        customer.setAddress("Pune");
//        customer.setEmail("dummy@demo.com");
//        customer.setName("Vishwa");
//        customer.setOrders(List.of(
//                new Order(101L, 450.0, "Paneer Tikka", OrderStatus.ORDERED, LocalDate.now()),
//                new Order(102L, 500.0, "Chicken Hundi", OrderStatus.DELIVERED, LocalDate.now())
//        ) );
//        customerService.save(customer);

//        Optional<Customer> customer = customerService.getById(4L);
//        customer.ifPresent(System.out::println);
//        customer.get().setOrders(
//                List.of(new Order(103L, 350.0, "Chicken Biryani", OrderStatus.CANCELLED, LocalDate.now()))
//        );

//        customer.ifPresent(customerService::delete);


//        Customer customer = new Customer();
//        customer.setAddress("Pune");
//        customer.setEmail("dummydeva@demo.com");
//        customer.setName("Deva");
//        customerService.save(customer);
//
//        Optional<Customer> customer = customerService.getById(8L);
//        List<Order> l = new ArrayList<Order>();
//        l.add(new Order(104L, 350.0, "Chicken Biryani", OrderStatus.DELIVERED, LocalDate.now()));
//        customer.get().setOrders(l);
//
//        customerService.save(customer.get());

        Optional<Order> o = orderService.getById(103L);
        o.ifPresent(System.out::println);
        o.get().setOrderStatus(OrderStatus.REFUNDED);
        o.ifPresent(System.out::println);
    }
}
