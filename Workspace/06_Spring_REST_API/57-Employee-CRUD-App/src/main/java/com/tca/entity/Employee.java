package com.tca.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 128)
    private String name;

    @Column(name = "SALARY", columnDefinition = "FLOAT CHECK(SALARY > 0)")
    private Double salary;

    @Column(name = "CITY", nullable = false, length = 128)
    private String city;
}
