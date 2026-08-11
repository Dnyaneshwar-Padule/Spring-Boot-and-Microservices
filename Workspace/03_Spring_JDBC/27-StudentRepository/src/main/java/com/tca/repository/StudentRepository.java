package com.tca.repository;

import com.tca.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    private JdbcTemplate template;

    public StudentRepository(JdbcTemplate template){
        this.template = template;
    }

    public boolean save(Student student){
        final String saveSQL = "INSERT INTO student VALUES(?,?,?)";
        return template.update(saveSQL, student.getRno(), student.getName(), student.getPer()) == 1;
    }

    public int delete(Student student){
        final String deleteSQL = "DELETE FROM student WHERE rno = ?";
        return template.update(deleteSQL, student.getRno());
    }

    public int update(Student student){
        final String updateSQL = "UPDATE student SET name = ?, per = ? WHERE rno = ?";
        return template.update(updateSQL, student.getName(), student.getPer(), student.getRno());
    }

    /*
    // No city field in Student Entity
    public int deleteByCity(String city){
        final String deleteSQL = "DELETE from student WHERE city = ?";
        return template.update(deleteSQL, city);
    }
    */

    public Map<String, Object> getByRno(Integer rno){
        final String query = "SELECT * FROM student WHERE rno = ?";
        return template.queryForMap(query, rno);
    }

    /*
    public List<Map<String, Object>> getByCity(String city){
        final String query = "SELECT * FROM student WHERE city = ?";
        return template.queryForList(query, city);
    }
     */

    public List<Map<String, Object>> getAll(){
        final String query = "SELECT * FROM student";
        return template.queryForList(query);
    }
}

