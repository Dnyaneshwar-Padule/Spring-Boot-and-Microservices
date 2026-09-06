package com.tca.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Locale;

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

@NamedQuery(
        name = "Student.fetchAllByPerGreaterThanAndGender",
        query = "SELECT s From Student s WHERE s.per > :per AND s.gender = :gender"
)

@NamedQuery(
        name="Student.updateName",
        query = "UPDATE Student s SET s.name = :newName WHERE s.id = :id"
)

@NamedQuery(
        name = "Student.fetchByGenderAndName",
        query = "SELECT s FROM Student s WHERE s.gender = :gender AND s.name = :name"
)

@NamedQuery(
        name = "Student.countByGender",
        query = "SELECT s.gender , COUNT(s) count FROM Student s GROUP BY s.gender"
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