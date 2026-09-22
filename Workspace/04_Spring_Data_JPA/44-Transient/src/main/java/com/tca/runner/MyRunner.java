package com.tca.runner;

import com.tca.entity.Student;
import com.tca.service.StudentService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements ApplicationRunner {

    private final StudentService  studentService;

    public MyRunner(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
       /*
        Student student = new Student();
        student.setName("Ravi");
        student.setPercentage(78.0);
        studentService.save(student);
        System.out.println(student);
        System.out.println("Grade : " + student.getGrade());

        */

        Student student = studentService.getById(1L).orElse(null);
        System.out.println(student);

    }
}
