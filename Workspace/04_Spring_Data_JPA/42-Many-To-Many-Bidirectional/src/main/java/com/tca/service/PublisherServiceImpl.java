package com.tca.service;

import com.tca.entity.Publisher;
import com.tca.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("publisherService")
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Optional<Publisher> getById(Long id) {
        return publisherRepository.findById(id);
    }

    @Override
    public Optional<Publisher> getByName(String name) {
        return publisherRepository.findPublisherByName(name);
    }

    @Override
    public Optional<Publisher> getByEmail(String email) {
        return publisherRepository.findPublisherByEmail(email);
    }
}
