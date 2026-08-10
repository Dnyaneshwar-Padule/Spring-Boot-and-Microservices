package com.tca.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private JdbcTemplate template;

    @Autowired
    public StudentRepository(JdbcTemplate template){
        this.template = template;
        System.out.println("StudentRepository is created successfully !");
    }


}
