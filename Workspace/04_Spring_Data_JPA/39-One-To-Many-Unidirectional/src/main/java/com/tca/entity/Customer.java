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

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE} )
    @JoinColumn(name = "CUSTOMER_ID")
    /*
        This is database side table, it will be created in ORDER TABLE, it's the Foreign Key in ORDER TABLE
        Usually, we write @JoinColumn in at @ManyToOne (the entity which owns the relationship), but since it is unidirectional
        we can't write it in the Order (Relationship owning entity), so we have to write it here.
     */
    private List<Order> orders;

}
