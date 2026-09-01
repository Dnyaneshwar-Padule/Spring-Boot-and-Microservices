package com.tca.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity

@NamedQuery(
        name="Student.fetchByNameAndCity",
        query = "SELECT s FROM Student s WHERE s.name = :name AND s.city = :city"
)

@NamedQuery(
        name="Student.fetchByCityAndGender",
        query="SELECT s FROM Student s WHERE s.city = :city AND s.gender = :gender"
)
public class Student {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PER", columnDefinition = "FLOAT CHECK(PER >= 0 AND PER <= 100)")
    private Double per;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Enumerated
    @Column(name = "GENDER", nullable = false)
    private Gender gender;

    @Column(name = "BIRTH_DATE", nullable = false)
    private LocalDate birthDate;
}