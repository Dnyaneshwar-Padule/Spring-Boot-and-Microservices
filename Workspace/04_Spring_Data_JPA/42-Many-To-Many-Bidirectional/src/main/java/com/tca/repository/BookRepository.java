package com.tca.repository;

import com.tca.entity.Book;
import com.tca.entity.Genre;
import com.tca.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findBookByIsbn(String isbn);

    List<Book> findBooksByGenre(Genre genre);

    List<Book> findBooksByLanguage(Language language);

    List<Book> findBooksByGenreAndLanguage(Genre genre, Language language);


}
