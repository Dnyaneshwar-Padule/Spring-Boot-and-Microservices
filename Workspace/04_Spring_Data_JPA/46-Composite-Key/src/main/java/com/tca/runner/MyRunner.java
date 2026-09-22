package com.tca.runner;

import com.tca.entity.*;
import com.tca.service.CustomerService;
import com.tca.service.OrderService;
import com.tca.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class MyRunner implements ApplicationRunner {

    private final OrderService orderService;
    private final CustomerService customerService;
    private final ProductService productService;

    public MyRunner(OrderService orderService, CustomerService customerService, ProductService productService) {
        this.orderService = orderService;
        this.customerService = customerService;
        this.productService = productService;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        /* ###### We got some products ##########  */
        /*
        Product p1 = new Product();
        p1.setName("Asus Marshmallow Bluetooth mouse");
        p1.setPrice(1199.0);
        p1.setQuantity(50);

        Product p2 = new Product();
        p2.setName("Asus Marshmallow Bluetooth keyboard");
        p2.setPrice(2399.0);
        p2.setQuantity(35);

        Product p3 = new Product();
        p3.setName("MI Dual Driver wired earphones");
        p3.setPrice(799.0);
        p3.setQuantity(25);

        productService.save(p1);
        productService.save(p2);
        productService.save(p3);
         */


        /*  #####  Some customers created account  #####  */
        /*
        Address a1 = new Address();
        a1.setCity("Terkheda");
        a1.setPinCode("413525");
        a1.setState("Maharashtra");

        Customer c1 = new Customer();
        c1.setName("Dnyaneshwar");
        c1.setEmail("dnyaneshwar@demo.com");
        c1.setBirthDate(LocalDate.of(2006, 5, 31));
        c1.setAddress(a1);


        Address a2 = new Address();
        a2.setCity("Sangli");
        a2.setPinCode("416416");
        a2.setState("Maharashtra");

        Customer c2 = new Customer();
        c2.setAddress(a2);
        c2.setName("Athrva");
        c2.setEmail("athrva@demo.com");
        c2.setBirthDate(LocalDate.of(2006, 11, 21));

        customerService.save(c1);
        customerService.save(c2);
        */

        /* ### Create an order ###  */
//        Customer customer = customerService.getById(1L).orElse(null);
//        Product p1 = productService.getById(1L).orElse(null);
//        Product p2 = productService.getById(2L).orElse(null);
//
//        OrderItem item1 = new OrderItem();
//        item1.setProduct(p1);
//        item1.setQuantity(1);
//        item1.setPrice( p1.getPrice() * item1.getQuantity() );
//        p1.setQuantity( p1.getQuantity() - item1.getQuantity() );
//
//        OrderItem item2 = new OrderItem();
//        item2.setProduct(p2);
//        item2.setQuantity(1);
//        item2.setPrice( p2.getPrice() * item2.getQuantity() );
//        p2.setQuantity( p2.getQuantity() - item2.getQuantity() );
//
//        List<OrderItem> cartItems = new ArrayList<>();
//        cartItems.add(item1);
//        cartItems.add(item2);
//
//        Order order = orderService.placeOrder(customer, cartItems);


        /* Same Customer creates new order */
//        Customer customer = customerService.getById(1L).orElse(null);
//        Product product = productService.getById(3L).orElse(null);
//
//        OrderItem item = new OrderItem();
//        item.setProduct(product);
//        item.setQuantity(1);
//        item.setPrice( product.getPrice() * item.getQuantity() );
//        product.setQuantity( product.getQuantity() - item.getQuantity() );
//
//        List<OrderItem> cartItems = new ArrayList<>();
//        cartItems.add(item);
//
//        Order order = orderService.placeOrder(customer, cartItems);


        /* Another customer creates an order */
        Customer customer = customerService.getById(2L).orElse(null);
        Product product = productService.getById(3L).orElse(null);

        OrderItem item = new OrderItem();
        item.setProduct(product);
        item.setQuantity(2);
        item.setPrice( product.getPrice() * item.getQuantity() );
        product.setQuantity( product.getQuantity() - item.getQuantity() );

        List<OrderItem> cartItems = new ArrayList<>();
        cartItems.add(item);

        Order order = orderService.placeOrder(customer, cartItems);


    }
}
