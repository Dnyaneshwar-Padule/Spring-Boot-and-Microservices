package com.tca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a staff member in the HR system.
 */
@Getter
@Setter
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    public static final int MAX_NAME_LENGTH = 128;
    public static final int MAX_CITY_LENGTH = 128;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME", nullable = false, length = MAX_NAME_LENGTH)
    private String name;

    /**
     * Monthly gross salary in local currency. Must be strictly positive.
     */
    @Column(name = "SALARY", columnDefinition = "FLOAT CHECK(SALARY > 0)")
    private Double salary;

    @Column(name = "CITY", nullable = false, length = MAX_CITY_LENGTH)
    private String city;
}
