package com.tca.runner;

import com.tca.entity.*;
import com.tca.service.AuthorService;
import com.tca.service.BookService;
import com.tca.service.PublisherService;
import jakarta.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class MyRunner implements ApplicationRunner {

    private final PublisherService publisherService;
    private final AuthorService authorService;
    private final BookService bookService;

    public MyRunner(PublisherService publisherService, AuthorService authorService, BookService bookService) {
        this.publisherService = publisherService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        /* #### A new Author came, but currently haven't written any book #### */
        /*
        Author author = new Author();
        author.setName("Viraj");
        author.setGender(Gender.MALE);
        author.setEmail("vaibhav@gmail.com");
        author.setCity("Indore");
        author.setBirthDate(LocalDate.of(2000, 1, 1));
        authorService.save(author);
        */

        /*  #### Above author wrote a book and a publisher accepted to publish their book ####  */
        /*
        Author author = authorService.getByEmail("vaibhav@gmail.com").orElse(null);

        Publisher publisher = new Publisher();
        publisher.setName("Motilal Banarsidass");
        publisher.setEmail("naraina@mlbd.in");
        publisher.setEstablishedYear(1903);

        Book book = new Book();
        book.setTitle("The Jar of Sweet Regrets");  // Story of rat trapped in a jar with food.
        book.setIsbn("2009000900090");
        book.setLanguage(Language.ENGLISH);
        book.setPrice(690.0);
        book.setReleaseDate(LocalDate.now());
        book.setEdition(1);
        book.setGenre(Genre.FICTION);

        bookService.save(
            book,
            Arrays.asList(author),
            publisher
        );
        */

        /*  ####  A new book with new Publisher and new Author  ####  */
        Author author_1 = new Author();
        author_1.setName("Dennis Ritchie");
        author_1.setGender(Gender.MALE);
        author_1.setEmail("dmr@alice.att.com");
        author_1.setCity("Bronxville, New York");
        author_1.setBirthDate(LocalDate.of(1941, 9, 9)); //

        Author author_2 = new Author();
        author_2.setName("Brian Wilson Kernighan");
        author_2.setGender(Gender.MALE);
        author_2.setEmail("bwk@cs.princeton.edu");
        author_2.setCity("Princeton, New Jersey, USA");
        author_2.setBirthDate(LocalDate.of(1942, 1, 30));

        Publisher publisher = new Publisher();
        publisher.setName("Prentice Hall");
        publisher.setEmail("info@pearsoned.com");
        publisher.setEstablishedYear(1913);

        Book book = new Book();
        book.setTitle("The C Programming Language");  // The definitive guide and reference for the C language by its creators.
        book.setIsbn("9780131103627");
        book.setLanguage(Language.ENGLISH);
        book.setPrice(3400.0);
        book.setReleaseDate(LocalDate.of(1988, 4, 1));
        book.setEdition(2);
        book.setGenre(Genre.EDUCATION);

        bookService.save(
                book,
                Arrays.asList(author_1, author_2),
                publisher
        );


    }
}
