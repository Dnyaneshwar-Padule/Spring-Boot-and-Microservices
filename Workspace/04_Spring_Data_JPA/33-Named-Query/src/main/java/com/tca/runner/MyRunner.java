package com.tca.runner;

import com.tca.entity.Gender;
import com.tca.entity.Student;
import com.tca.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements ApplicationRunner {

    @Autowired
    private StudentService studentService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        for(Student student : studentService.findByNameAndCity("Dnyaneshwar Padule", "Pune") ){
            System.out.println(student);
        }

        System.out.println("-".repeat(15));

        for(Student student : studentService.findByCityAndGender("Pune", Gender.MALE)){
            System.out.println(student);
        }

    }
}
