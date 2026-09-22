package com.tca.runner;

import com.tca.entity.Address;
import com.tca.entity.Person;
import com.tca.service.PersonService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements ApplicationRunner {

    private final PersonService personService;

    public MyRunner(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        /*
        Address address = new Address();
        address.setCity("Talegaon Dabhade");
        address.setState("Maharashtra");
        address.setPinCode("410507");

        Person person = new Person();
        person.setName("Niraj");
        person.setAddress(address);

        personService.save(person);
        System.out.println(person);

         */

        Person person = personService.getById(1L).orElse(null);
        System.out.println(person);
    }
}
