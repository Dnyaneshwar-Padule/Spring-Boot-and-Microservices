package com.tca.runner;

import com.tca.entity.Address;
import com.tca.entity.Customer;
import com.tca.entity.Product;
import com.tca.service.CustomerService;
import com.tca.service.OrderService;
import com.tca.service.ProductService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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

        
    }
}
