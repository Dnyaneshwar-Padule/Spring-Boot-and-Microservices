package com.tca.runner;

import com.tca.entity.Customer;
import com.tca.entity.Order;
import com.tca.entity.OrderStatus;
import com.tca.service.CustomerService;
import com.tca.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

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

        /// //////////////////////////////////////////////////
        /* #####   Customer created account    #########  */
        /// //////////////////////////////////////////////////
        /*
        //Save one customer record.
        Customer customer = new Customer();
        customer.setEmail("dummy1@demo.com");
        customer.setName("Arun");
        customer.setAddress("Kothrud, Pune");
        customerService.save(customer);
        System.out.println(customer);

        */


        /// //////////////////////////////////////////////
        /* #### Customer placing orders  ####  */
        /// /////////////////////////////////////////////
        /*
        // fetch record of above customer
        Customer customer = customerService.getById(1L).orElse(null);

        // Create orders for this customer
        Order o1 = new Order();
        o1.setOrderStatus(OrderStatus.ORDERED);
        o1.setItem("Paneer tikka");
        o1.setPrice(300.0);
        o1.setOrderDate(LocalDate.now());

        Order o2 = new Order();
        o2.setOrderStatus(OrderStatus.ORDERED);
        o2.setItem("Chicken Biryani");
        o2.setPrice(250.0);
        o2.setOrderDate(LocalDate.now());

        // Make this method Transactional, so that this works, else we will get exception, DetachedEntity.....
        orderService.save(o1, customer);
        orderService.save(o2, customer);
        */

        /// //////////////////////////////////////////////////
        /* ##### Customer changed his mind....... ##### */
        /// ///////////////////////////////////////////////////
        /*
        // fetch customer record (with id 1L)
        Customer customer = customerService.getById(1L).orElse(null);

        // Get order details and update status of 1st Order, as canceled
        for(Order o : customer.getOrders()){ // may throw NullPointerException if there are no orders, but for now, we know there are 2 orders
            if(o.getId() == 1L){
                o.setOrderStatus(OrderStatus.CANCELLED);
                orderService.save(o, customer);
                break;
            }
        }
         */

        /// //////////////////////////////////////////////////
        // ASSIGNMENT
        // Delete order, but customer should not get deleted.
        /// //////////////////////////////////////////////////

        /////////////
        // Option 1
        // don't delete order record too, dereference the customer_id, i.e. make customer_id null for that order
        // Can be achieved easily by making orphanRemoval=false in Customer entity
        // step 1 : fetch customer   (  Customer customer = customerService.getById(1L).orElse(null)    )
        // step 2 : fetch orders     (   List<Order> orders = customer.getOrders()                      )
        // step 3 : remove order from  orders list  (    orders.remove(1)     )
        /// ////////


        /// //////////
        // Option 2
        // delete order but don't cascade the change, i.e. don't cascade on delete
        // To do this, don't use  CascadeType.REMOVE or  CascadeType.ALL in Order entity
        // Order o1 = orderService.getById(1L).orElse(null);
        // orderService.delete(o1);
        // Customer customer = customerService.getById(1L).orElse(null);
        // System.out.println(customer.getId());
        // Order is deleted, but customer isn't
        /// //////////



    }
}
