package com.tca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 128)
    private String name;

    @Column(name = "EMAIL", nullable = false, unique = true, length = 128)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name="GENDER")
    private Gender gender;

    @Column(name="CITY", nullable = false, length = 64)
    private String city;

    /*Unidirectional relationship */
    /* I am only interested to see Books by Authors. */
    @ManyToMany(
            cascade = {    /* We don't want CascadeType.REMOVEs */
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY  /* It's default though. */
    )
    @JoinTable(
            name = "AUTHOR_BOOK", /* name for junction table. */
            joinColumns = @JoinColumn(name = "AUTHOR_ID"), /* Foreign key referring Author.id */
            inverseJoinColumns = @JoinColumn(name = "BOOK_ID") /* Foreign key referring Book.id */
    )
    private List<Book> books = new ArrayList<>();
}
