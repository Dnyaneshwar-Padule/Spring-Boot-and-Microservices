package com.tca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="PRICE", columnDefinition = "FLOAT CHECK(PRICE > 0)")
    private Double price;

    @Column(name="ITEM", nullable = false, length = 100)
    private String item;

    @Enumerated(EnumType.STRING)
    @Column(name="ORDER_STATUS", nullable = false)
    private OrderStatus  orderStatus;

    @Column(name="ORDER_DATE", nullable = false)
    private LocalDate orderDate;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id")
    /*
        customer_id is an database side attribute used to store foreign key (customer.id) in orders table
        In ManyToOne or OneToMany, the table at Many side (here, orders) always stores the foreign key (i.e. here customer_id)
        Since that table stores the foreign key, that table is called as Owner of the relationship or relationship owning side.
        here, orders is the owner of the relationship
        and @JoinColumn is always written at the owning side, and we write mappedBy attribute in inverse side (i.e. Customer entity)
    */
    private Customer customer;

}
