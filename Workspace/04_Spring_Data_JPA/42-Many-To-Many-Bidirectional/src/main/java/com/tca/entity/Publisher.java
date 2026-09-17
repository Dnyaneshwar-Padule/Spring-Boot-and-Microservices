package com.tca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", unique = true, nullable = false, length = 128)  /* Publication name is unique. */
    private String name;

    @Column(name = "EMAIL", unique = true, nullable = false, length = 128)
    private String email;

    @Column(name = "ESTABLISHED_YEAR", nullable = false)
    private Integer establishedYear;


    /*
         Associations
        -----------------------
        For now, let the Publisher be related only to the book
        It will be OneToMany relationship
        One publisher publishes multiple books
        i.e. One publisher is related to multiple books
     */
    @OneToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY,
            mappedBy = "publisher"
    )
    private List<Book> books;


    // Some helper methods

    /**
     * This helper method manages relationship of both sides
     * @param book
     */
    public void addBook(Book book){
        if(books == null)
            books = new ArrayList<>();
        books.add(book);
        book.setPublisher(this);
    }
}
