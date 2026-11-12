package com.tca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Entity(name="STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer rno;

    @NotNull(message = "{NotNull.student.name}")
    @Size(min = 2, max = 64, message = "{Size.student.name}")
    @Column(name="NAME", nullable = false, length = 64)
    private String name;

    @DecimalMin(value = "0.0", inclusive = true, message = "{DecimalMin.student.per}")
    @DecimalMax(value = "100.0", inclusive = true, message = "{DecimalMax.student.per}")
    @Column(name="PER", columnDefinition = "FLOAT CHECK(PER >= 0 and PER <= 100 )")
    private Float per;

    @NotNull(message = "{NotNull.student.city}")
    @Size(min = 2, max = 64, message = "{Size.student.city}")
    @Column(name="CITY", nullable = false, length = 64)
    private String city;

    @NotNull(message = "{NotNull.student.email}")
    @Email(message = "{Email.student.email}")
    @Size(min=6, max = 128, message = "{Size.student.email}")
    @Column(name="EMAIL", nullable = false, unique = true, length = 128)
    private String email;

    @NotNull(message = "{NotNull.student.phone}")
    @Pattern(regexp = "^[0-9]{10}$", message = "{Pattern.student.phone}")
    @Column(name="PHONE", nullable = false, unique = true, length = 10)
    private String phone;

    @NotNull(message = "{NotNull.student.birthDate}")
    @Past(message = "{Past.student.birthDate}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name="BIRTH_DATE", nullable = false)
    private LocalDate birthDate;
}
