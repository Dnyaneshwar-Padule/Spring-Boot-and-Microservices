package com.tca.entity;

import com.tca.generator.PassportNo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Passport {

    @Id
    @PassportNo
    @Column(name = "PASSPORT_NO", length = 9)
    private String passportNo;

    @Column(name="EXPIRY_DATE", nullable = false)
    private LocalDate expiryDate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "passport")
    private Person person;
}
