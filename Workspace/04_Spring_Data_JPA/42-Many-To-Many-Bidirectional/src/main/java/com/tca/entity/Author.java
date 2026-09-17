package com.tca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 128)  /* Publication name is unique. */
    private String name;

    @Column(name = "EMAIL", length = 128, nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER")
    private Gender gender;

    @Column(name = "CITY", nullable = false, length = 64)
    private String city;

    @Column(name = "BIRTH_DATE", nullable = false)
    private LocalDate birthDate;


    /*
            Relationships/Associations
            Books (Many-To-Many)
     */

    /*
            One Author can write/publish multiple books
            and one book can also have multiple authors
            so, it's ManyToMany relationship/association

        Note: we have already defined Book as the owning side for this relationship.
    */
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY,
            mappedBy = "authors"
    )
    private List<Book> books;

}
