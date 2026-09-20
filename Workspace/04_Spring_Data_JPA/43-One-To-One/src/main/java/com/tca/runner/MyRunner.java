package com.tca.runner;

import com.tca.entity.Passport;
import com.tca.entity.Person;
import com.tca.service.PassportService;
import com.tca.service.PersonService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MyRunner  implements ApplicationRunner {

    private final PersonService personService;
    private final PassportService passportService;

    public MyRunner(PersonService personService, PassportService passportService) {
        this.personService = personService;
        this.passportService = passportService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        /*  Save one record */
        Person p = new Person();
        p.setName("Aniruddha");
        p.setBirthDate(LocalDate.now());

        Passport passport = new Passport();
        passport.setExpiryDate(LocalDate.now().plusYears(10));

        passport.setPerson(p);
        p.setPassport(passport);

        passportService.save(passport);

        System.out.println("Passport No: " + passport.getPassportNo());
        System.out.println("Person ID : " + p.getId());
    }
}
