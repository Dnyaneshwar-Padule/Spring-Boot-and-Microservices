package com.tca.runner;


import com.tca.entity.Gender;
import com.tca.entity.Student;
import com.tca.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class MyRunner implements ApplicationRunner {

    @Autowired
    private StudentService studentService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Student s = new Student(101,"Dnyaneshwar Padule", 90.23, "Pune", Gender.MALE, LocalDate.of(2006,5,31));
        Student s = new Student(102,"Athrva Gheware", 91.40, "Sangli", Gender.MALE, LocalDate.of(2006,11,21));

        s = studentService.save(s);
        System.out.println("Student is saved successfully !");

        for(Student student : studentService.findAll()){
            System.out.println(student);
        }
    }
}
