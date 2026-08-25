package com.tca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "STUDENT")
public class Student {

    @Id
    @Column(name = "RNO")
    private Integer rno;

    @Column(name="NAME", nullable = false)
    private String name;

    @Column(name="PER", columnDefinition = "CHECK(PER >= 0 and PER <= 100)")
    private Double per;

    @Column(name="CITY", nullable = false)
    private String city;

    @Enumerated
    @Column(name = "GENDER")
    private Gender gender;

    @Column(name = "BIRTH_DATE", nullable = false)
    private LocalDate birthDate;
}
