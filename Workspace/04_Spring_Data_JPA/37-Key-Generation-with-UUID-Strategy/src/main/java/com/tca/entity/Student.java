package com.tca.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="NAME", nullable = false, length = 48)
    private String name;

    @Column(name="PER", columnDefinition = "FLOAT CHECK(PER >= 0 AND PER <= 100)")
    private Double per;

    @Column(name="CITY", nullable = false, length = 48)
    private String city;

    @Enumerated(EnumType.STRING)
    @Column(name="GENDER", nullable = false)
    private Gender gender;

    @Column(name="BIRTH_DATE", nullable = false)
    private LocalDate birthDate;

}
