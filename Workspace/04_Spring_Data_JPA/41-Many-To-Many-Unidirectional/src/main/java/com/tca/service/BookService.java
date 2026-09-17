package com.tca.service;

import com.tca.entity.Book;

import java.util.Optional;

public interface BookService {

    public Book save(Book book);

    public Optional<Book> getById(Long id);

}
