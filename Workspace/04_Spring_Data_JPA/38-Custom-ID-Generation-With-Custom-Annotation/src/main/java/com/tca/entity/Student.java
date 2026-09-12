package com.tca.entity;

import com.tca.generator.TcaId;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Student {

    @Id
    @TcaId(name="TCA-CJ")
    private String id;

    @Column(name="NAME", nullable = false, length = 48)
    private String name;

    @Column(name="PER", columnDefinition = "FLOAT(PER >= 0 AND per <= 100)")
    private Double per;

    @Column(name="CITY", nullable = false, length = 48)
    private String city;

    @Enumerated(EnumType.STRING)
    @Column(name="GENDER", nullable = false)
    private Gender gender;

    @Column(name="BIRTH_DATE", nullable = false)
    private LocalDate birthDate;

}
