package com.tca.service;

import com.tca.entity.*;
import com.tca.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("bookService")
public class BookServiceImpl  implements  BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book, List<Author> authors, Publisher publisher) {
        book.setAuthors(authors);
        book.setPublisher(publisher);
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> getById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> getByIsbn(String isbn) {
        return bookRepository.findBookByIsbn(isbn);
    }

    @Override
    public List<Book> getBooksByGenre(Genre genre) {
        return bookRepository.findBooksByGenre(genre);
    }

    @Override
    public List<Book> getBooksByLanguage(Language language) {
        return bookRepository.findBooksByLanguage(language);
    }

    @Override
    public List<Book> getBooksByGenreAndLanguage(Genre genre, Language language) {
        return bookRepository.findBooksByGenreAndLanguage(genre, language);
    }
}
