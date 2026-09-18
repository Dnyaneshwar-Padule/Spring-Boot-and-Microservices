package com.tca.service;

import com.tca.entity.Author;
import com.tca.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Optional<Author> getById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> getByEmail(String email) {
        return authorRepository.findAuthorByEmail(email);
    }
}
