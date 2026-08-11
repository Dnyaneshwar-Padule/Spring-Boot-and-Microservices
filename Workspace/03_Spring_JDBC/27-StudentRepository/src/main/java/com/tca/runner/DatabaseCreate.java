package com.tca.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

//@Component
public class DatabaseCreate implements ApplicationRunner {

    private JdbcTemplate template;

//    @Autowired
    public DatabaseCreate(JdbcTemplate  template){
        this.template = template;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final String dropTableSQL = "DROP TABLE IF EXISTS student";
        final String createSQL = "CREATE TABLE student(rno int, name varchar(32), per float)";
        final String insertSQL_1 = "INSERT INTO student VALUES(1,'Athrva', 92)";
        final String insertSQL_2 = "INSERT INTO student VALUES(2, 'Aditya', 82)";
        final String insertSQL_3 = "INSERT INTO student VALUES(3, 'Aniruddha', 85)";

        template.execute(dropTableSQL);
        template.execute(createSQL);
        template.update(insertSQL_1);
        template.update(insertSQL_2);
        template.update(insertSQL_3);

        System.out.println("***** CREATE SUCCESSFUL ****");
    }
}
