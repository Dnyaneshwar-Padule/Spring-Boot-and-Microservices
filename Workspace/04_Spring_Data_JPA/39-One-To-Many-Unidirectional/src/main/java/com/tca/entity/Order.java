package com.tca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="ORDERS") /* ORDER is a reserved word */
public class Order {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PRICE", columnDefinition = "FLOAT CHECK(PRICE > 0)")
    private Double price;

    @Column(name="ITEM", nullable = false)
    private String item;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_STATUS", nullable = false)
    private OrderStatus orderStatus;

    @Column(name = "ORDER_DATE", nullable = false)
    private LocalDate orderDate;

    // we won't fetch user from order, so no relationship here.
}
