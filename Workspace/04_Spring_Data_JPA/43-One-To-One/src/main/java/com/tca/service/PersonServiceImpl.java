package com.tca.service;

import com.tca.entity.Person;
import com.tca.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("personService")
public class PersonServiceImpl implements  PersonService{

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Optional<Person> getById(Long id) {
        return personRepository.findById(id);
    }
}
