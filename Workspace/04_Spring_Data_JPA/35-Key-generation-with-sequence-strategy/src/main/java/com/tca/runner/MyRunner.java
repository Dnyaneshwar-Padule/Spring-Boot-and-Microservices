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
        s.setBirthDate(LocalDate.now());
        s.setName("Ramesh");
        s.setPer(89.0);
        s.setCity("Pune");
        s.setGender(Gender.MALE);


        System.out.println(studentService.save(s));


//        Student s1 = new Student();
//        s1.setBirthDate(LocalDate.now());
//        s1.setName("Ram");
//        s1.setPer(89.0);
//        s1.setCity("Pune");
//        s1.setGender(Gender.MALE);
//        System.out.println(studentService.save(s1));
    }
}
