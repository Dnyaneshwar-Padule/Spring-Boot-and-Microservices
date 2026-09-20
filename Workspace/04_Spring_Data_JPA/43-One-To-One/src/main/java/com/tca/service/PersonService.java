package com.tca.service;

import com.tca.entity.Person;

import java.util.Optional;

public interface PersonService {

    Person save(Person person);

    Optional<Person> getById(Long id);
}
