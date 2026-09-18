package com.tca.service;

import com.tca.entity.Publisher;

import java.util.Optional;

public interface PublisherService {

    public Publisher save(Publisher publisher);

    public Optional<Publisher> getById(Long id);

    public Optional<Publisher> getByName(String name);

    public Optional<Publisher> getByEmail(String email);
}
