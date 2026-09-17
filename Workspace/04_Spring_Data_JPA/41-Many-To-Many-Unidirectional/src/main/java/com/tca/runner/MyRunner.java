package com.tca.runner;

import com.tca.entity.Author;
import com.tca.entity.Book;
import com.tca.entity.Gender;
import com.tca.service.AuthorService;
import com.tca.service.BookService;
import jakarta.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class MyRunner  implements ApplicationRunner {

    private final AuthorService authorService;
    private final BookService bookService;

    public MyRunner(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        /* #####  A new author came with a book.  #####  */
        /*
        Author author = new Author();
        author.setCity("Pune");
        author.setName("Anil");
        author.setGender(Gender.MALE);
        author.setEmail("dummy1@demo.com");

        Book book = new Book();
        book.setISBN("123456789");
        book.setPrice(699.0);
        book.setTitle("The Life Of a Bee");
        book.setReleaseDate(LocalDate.now());

        author.getBooks().add(book);
        authorService.save(author);
         */


        /* ####  Author with emailID: dummy1@demo.com came with new book #### */
        /*
        Author author = authorService.getByEmail("dummy1@demo.com").orElse(null);

        Book book = new Book();
        book.setTitle("The Tiger Who Used To Smoke");
        book.setPrice(780.0);
        book.setISBN("123456790");
        book.setReleaseDate(LocalDate.now());

        // author.setBooks(Arrays.asList(book));  // If we set book without fetching existing books, then previous books will be removed. CascadeType.MERGE
        author.getBooks().add(book);
        authorService.save(author);
        */


        /*  ### Author with email: dummy1@demo.com wants to remove one of his book  */
        // It will keep book info, it only removes the author<->book relation from author_book table.
        // authorService.getByEmail("dummy1@demo.com").orElse(null).getBooks().remove(0);  // Leave rest to Hibernate
        // to completely delete the book record, call delete() or softDelete() on that book.
    }

}
