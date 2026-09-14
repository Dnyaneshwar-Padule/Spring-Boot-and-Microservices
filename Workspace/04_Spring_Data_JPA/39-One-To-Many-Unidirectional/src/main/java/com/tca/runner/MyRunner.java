package com.tca.runner;

import com.tca.entity.Customer;
import com.tca.entity.Order;
import com.tca.entity.OrderStatus;
import com.tca.service.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class MyRunner implements ApplicationRunner {

    private final CustomerService customerService;

    public MyRunner(CustomerService customerService) {
        this.customerService = customerService;
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

        Optional<Customer> customer = customerService.getById(3L);
        customer.ifPresent(System.out::println);
        customer.ifPresent(customerService::delete);

    }
}
