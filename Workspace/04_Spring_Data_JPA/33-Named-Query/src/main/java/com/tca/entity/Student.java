package com.tca.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Locale;

@Data
@Entity

@NamedQuery(
        name = "Student.fetchByNameAndCity",
        query = "SELECT s FROM Student s WHERE s.name = :name AND s.city = :city"
)

@NamedNativeQuery(
        name = "Student.findByNameAndCity",
        query = "SELECT * FROM Student WHERE NAME = :name AND CITY = :city"
)

@NamedQuery(
        name = "Student.fetchByCityAndGender",
        query = "SELECT s FROM Student s WHERE s.city = :city AND s.gender = :gender"
)

@NamedNativeQuery(
        name = "Student.findByCityAndGender",
        query = "SELECT * FROM Student WHERE CITY = :city and GENDER = :gender"
)


@NamedQuery(
        name = "Student.fetchAllByPerGreaterThanAndGender",
        query = "SELECT s From Student s WHERE s.per > :per AND s.gender = :gender"
)

@NamedNativeQuery(
        name = "Student.findAllByPerGreaterThanAndGender",
        query = "SELCT * FORM Student WHERE PER > :per AND GENDER = :gender"
)

@NamedQuery(
        name = "Student.updateName",
        query = "UPDATE Student s SET s.name = :newName WHERE s.id = :id"
)

@NamedNativeQuery(
        name = "Student.modifyName",
        query = "UPDATE Student SET NAME = :newName WHERE ID = :id"
)

@NamedQuery(
        name = "Student.fetchByGenderAndName",
        query = "SELECT s FROM Student s WHERE s.gender = :gender AND s.name = :name"
)

@NamedQuery(
        name = "Student.countByGender",
        query = "SELECT s.gender , COUNT(s) count FROM Student s GROUP BY s.gender"
)

@NamedNativeQuery(
        name = "Student.getCountByGender",
        query = "SELECT GENDER , COUNT(*) count FROM Student  GROUP BY GENDER"
)

@NamedQuery(
        name = "Student.deleteByNameAndCity",
        query = "DELETE FROM Student s WHERE s.name = :name AND s.city = :city"
)

@NamedQuery(
        name = "Student.deleteByGenderAndBirthDate",
        query = "DELETE FROM Student s WHERE s.gender = :gender AND s.birthDate = :birthDate"
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