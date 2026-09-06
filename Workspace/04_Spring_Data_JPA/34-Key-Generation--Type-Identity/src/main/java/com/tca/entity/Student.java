package com.tca.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", length = 32, nullable = false)
    private String name;

    @Column(name = "PER", columnDefinition = "CHECK(PER >= 0 AND PER <= 100)")
    private Double per;

    @Column(name="CITY", nullable = false, length = 32)
    private String city;

    @Enumerated
    @Column(name="GENDER", nullable = false)
    private Gender gender;

    @Column(name="BIRTH_DATE", nullable = false)
    private LocalDate birthDate;


}
