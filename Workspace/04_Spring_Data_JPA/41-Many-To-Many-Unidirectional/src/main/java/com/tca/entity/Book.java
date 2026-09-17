package com.tca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ISBN", unique = true, nullable = false)
    private String ISBN;

    @Column(name = "TITLE", nullable = false, length = 128)
    private String title;

    @Column(name = "PRICE", columnDefinition = "FLOAT CHECK(PRICE > 0)")
    private Double price;

    @Column(name = "RELEASE_DATE", nullable = false)
    private LocalDate releaseDate;
}
