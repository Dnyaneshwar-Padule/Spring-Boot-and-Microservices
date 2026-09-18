package com.tca.repository;

import com.tca.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    public Optional<Publisher> findPublisherByName(String name);

    public Optional<Publisher> findPublisherByEmail(String email);
}
