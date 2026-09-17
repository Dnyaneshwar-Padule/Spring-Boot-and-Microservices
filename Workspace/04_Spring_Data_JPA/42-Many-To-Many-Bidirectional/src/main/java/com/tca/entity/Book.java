package com.tca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ISBN", nullable = false, unique = true, length = 13 /* max length is 13 */ )
    private String isbn;

    @Column(name="TITLE", nullable = false, length = 128)
    private String title;

    @Column(name="PRICE", columnDefinition = "FLOAT NOT NULL CHECK(PRICE > 0)")
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name="GENRE", nullable = false)
    private Genre genre;

    @Column(name="RELEASE_DATE", nullable = false)
    private LocalDate releaseDate;

    @Enumerated(EnumType.STRING)
    @Column(name="LANGUAGE", nullable = false)
    private Language language;  // String language would be better here, because there are so many languages, but for now it's ok !!

    @Column(name = "EDITION", nullable = false)
    private Integer edition; // Book edition number, like 1st edition, 2nd edition etc...

    /*
         Relationships/Associations
         Publisher and Author
     */

    /*
         A book has only one publisher
         and many books can have same publisher
         This is ManyToOne Relationship
    */
    @ManyToOne(
            cascade = {  /* we should not use Cascade.REMOVE, as deleting a book may cause deletion of Publisher too... */
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH
            },
            fetch = FetchType.EAGER /* default */
    )
    // Since this is many side, it will be the owner of the relationship
    @JoinColumn(
            name = "FK_PUBLISHER" /* Database table side foreign key column name, in Book table */
    )
    private Publisher publisher;


    /*   A book can have many authors
         A author can write many books
         It's ManyToMany relationship
     */
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY /* default */
    )
    // let's make books the owner of relationship, conceptually,
    // in many to many, nobody is owner of the relationship, it's all managed by the junction table
    @JoinTable(
            name = "BOOK_AUTHOR", /* name of the junction table */
            joinColumns = @JoinColumn(name = "FK_BOOK"),
            inverseJoinColumns = @JoinColumn(name = "FK_AUTHOR")
    )
    private List<Author> authors;
}
