package com.tca.runner;

import com.tca.entity.Gender;
import com.tca.entity.Student;
import com.tca.service.StudentService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MyRunner implements ApplicationRunner {

    private final StudentService studentService;

    public MyRunner(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Student s = new Student();
        s.setName("Mayur");
        s.setCity("Pune");
        s.setGender(Gender.MALE);
        s.setBirthDate(LocalDate.now());
        s.setPer(88.0);

        System.out.println(studentService.save(s));
    }
}
