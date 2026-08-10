package com.tca;

import com.tca.model.Student;
import com.tca.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application {

    private static StudentRepository studentRepository;

    public static void main(String[] args) {
        ConfigurableApplicationContext context =  SpringApplication.run(Application.class, args);
        studentRepository = context.getBean(StudentRepository.class);

        Student student = new Student();
//        student.setName("Pramod");
//        student.setRno(1);
//        student.setPer(77.0);

        student.setName("Shreekant");
        student.setRno(1);
        student.setPer(87.0);

        // System.out.println(studentRepository.save(student));

        //System.out.println( studentRepository.update(student) );

        System.out.println( studentRepository.delete(student) );


    }

}
