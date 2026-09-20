package com.tca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @TableGenerator(
            name = "pk_generator",
            table = "pk_generator",
            pkColumnName = "entity_name",
            pkColumnValue = "person_pk",
            valueColumnName = "last_val"
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "pk_generator")
    private Long id;

    @Column(name  = "NAME", nullable = false)
    private String name;

    @Column(name = "BIRTH_DATE", nullable = false)
    private LocalDate birthDate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "passport_no")
    private Passport passport;
}
