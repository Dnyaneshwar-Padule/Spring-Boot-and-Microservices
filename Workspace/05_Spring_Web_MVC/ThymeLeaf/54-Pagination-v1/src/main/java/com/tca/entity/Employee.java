package com.tca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "EMPLOYEE")
public class Employee {

    @Id
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SALARY")
    private Float salary;

    @Column(name = "CITY")
    private String city;
}
