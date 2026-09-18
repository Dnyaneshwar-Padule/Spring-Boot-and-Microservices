package com.tca.service;

import com.tca.entity.*;

import java.util.List;
import java.util.Optional;

public interface BookService {

    // A book always have author(s) and Publisher
    Book save(Book book, List<Author> authors, Publisher publisher);

    Optional<Book> getById(Long id);

    Optional<Book> getByIsbn(String isbn);

    List<Book> getBooksByGenre(Genre genre);

    List<Book> getBooksByLanguage(Language language);

    List<Book> getBooksByGenreAndLanguage(Genre genre, Language language);
}
