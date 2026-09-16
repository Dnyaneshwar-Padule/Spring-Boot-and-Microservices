package com.tca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NAME", nullable = false, length = 100)
    private String name;

    @Column(name="ADDRESS", nullable = false, length = 255)
    private String address;

    @Column(name = "EMAIL", nullable = false, unique = true, length = 128)
    private String email;

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            mappedBy = "customer", /* reference variable name in Order entity which refers to Customer (private Customer customer, in Order entity) */
            fetch = FetchType.LAZY
    )
    private List<Order> orders;
}
