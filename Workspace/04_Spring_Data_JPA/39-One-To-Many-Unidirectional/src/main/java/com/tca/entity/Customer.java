package com.tca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 32)
    private String name;

    @Column(name = "ADDRESS", length = 64, nullable = false)
    private String address;

    @Column(name = "EMAIL", length = 128, nullable = false, unique = true)
    private String email;

    // One-To-Many connection
    // User -> Orders

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, orphanRemoval = true )
    @JoinColumn(name = "CUSTOMER_ID")
    /*
        This is database side table, it will be created in ORDER TABLE, it's the Foreign Key in ORDER TABLE
        Usually, we write @JoinColumn in at @ManyToOne (the entity which owns the relationship), but since it is unidirectional
        we can't write it in the Order (Relationship owning entity), so we have to write it here.

        orphanRemoval:
            by default it is false.
            true:
                If we remove an order from orders (list), then that order is removed from the database too (from orders table)
            false:
                If we remove an order from the orders (list), then for that order the customer_id becomes null,
                the order remains in the table, but the customer_id becoes null

            * An order without customer_id makes no sense.....
     */
    private List<Order> orders;

}
