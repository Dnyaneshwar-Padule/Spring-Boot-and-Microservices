package com.tca.runner;

import com.tca.entity.Gender;
import com.tca.entity.Student;
import com.tca.service.StudentService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MyRunner implements ApplicationRunner {

    @Autowired
    private StudentService studentService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Student s = new Student();
        s.setName("Akash");
        s.setCity("Pune");
        s.setPer(89.98);
        s.setGender(Gender.MALE);
        s.setBirthDate(LocalDate.of(2005, 5, 21));

        studentService.save(s);
        System.out.println(s);


    }
}
