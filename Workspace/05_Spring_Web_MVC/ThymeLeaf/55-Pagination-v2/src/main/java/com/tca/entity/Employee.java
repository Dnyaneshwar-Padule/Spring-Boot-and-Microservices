package com.tca.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "EMPLOYEE")
public class Employee {

    @Id
    private Integer id;
    private String name;
    private Float salary;
    private String city;
}
