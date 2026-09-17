package com.tca.service;

import com.tca.entity.Author;

import java.util.Optional;

public interface AuthorService {

    public Author save(Author author);

    public Optional<Author> getById(Long id);

    public Optional<Author> getByEmail(String email);
}
