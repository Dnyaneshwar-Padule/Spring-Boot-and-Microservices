package com.tca.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
public class Student {

    @Id
    @SequenceGenerator(
            /* generator name */name="student_seq",
            /* database side name */sequenceName = "student_sequence",
            allocationSize = 50,
            initialValue = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    public Long id;

    @Column(name="NAME", nullable = false, length = 48)
    public String name;

    @Column(name="PER", columnDefinition = "FLOAT CHECK(PER >= 0 AND PER <= 100)")
    public Double per;

    @Column(name="CITY", nullable = false, length = 48)
    public String city;

    @Enumerated
    @Column(name="GENDER", nullable = false)
    public Gender gender;

    @Column(name="BIRTH_DATE", nullable = false)
    public LocalDate birthDate;
}
