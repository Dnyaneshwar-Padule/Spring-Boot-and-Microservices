package com.tca.repository;

import com.tca.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    public Optional<Author> findAuthorByEmail(String email);
}
