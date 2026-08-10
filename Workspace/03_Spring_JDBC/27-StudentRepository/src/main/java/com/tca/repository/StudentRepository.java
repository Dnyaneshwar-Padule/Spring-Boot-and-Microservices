package com.tca.repository;

import com.tca.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private JdbcTemplate template;

    public StudentRepository(JdbcTemplate template){
        this.template = template;
    }

    public boolean save(Student student){
        String saveSQL = "INSERT INTO student VALUES(?,?,?)";
        return template.update(saveSQL, student.getRno(), student.getName(), student.getPer()) == 1;
    }

    public int delete(Student student){
        String deleteSQL = "DELETE FROM student WHERE rno = ?";
        return template.update(deleteSQL, student.getRno());
    }

    public int update(Student student){
        String updateSQL = "UPDATE student SET name = ?, per = ? WHERE rno = ?";
        return template.update(updateSQL, student.getName(), student.getPer(), student.getRno());
    }

}
