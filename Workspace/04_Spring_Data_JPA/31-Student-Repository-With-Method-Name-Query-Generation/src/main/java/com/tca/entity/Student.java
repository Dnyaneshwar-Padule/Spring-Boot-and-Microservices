package com.tca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Student {

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="NAME", nullable = false)
    private String name;

    @Column(name="PER", columnDefinition = "FLOAT CHECK(PER >= 0 AND PER <= 100)")
    private Double per;

    @Column(name="CITY", nullable = false)
    private String city;

    @Enumerated
    @Column(name="GENDER", nullable = false)
    private Gender gender;

    @Column(name="BIRTH_DATE", nullable = false)
    private LocalDate birthDate;
}
