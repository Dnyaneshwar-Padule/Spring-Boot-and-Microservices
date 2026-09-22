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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 156)
    private String name;

    @Column(name = "PRICE", columnDefinition = "FLOAT NOT NULL CHECK(PRICE > 0)")
    private Double price;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

    @OneToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY,
            mappedBy = "product"

    )
    private List<OrderItem> orderItems;
}
