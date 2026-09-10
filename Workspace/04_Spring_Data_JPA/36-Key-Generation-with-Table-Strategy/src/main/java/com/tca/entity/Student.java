package com.tca.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Student {

    @TableGenerator(
            /* Spring Boot Name for generator */ name = "pk_generator",
            /* primary key allocation size */ allocationSize = 50,
            /* Starting/Initial value */ initialValue = 1,
            /* Database side attribute name which will be used to store primary key */ pkColumnName = "entity",
            pkColumnValue = "student_pk",
            table = "key_generator",
            valueColumnName = "last_value"

            /*
                Above table generator will create a table in the database like this
                 table name : key_generator
                    +------------+------------+
                    | entity     | last_value |
                    +------------+------------+
                    | student_pk |         51 |
                    +------------+------------+
             */
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "pk_generator")
    @Id
    private Long id;

    private String name;

    private Double per;

    private String city;

    private Gender gender;

    private LocalDate birthDate;
}
