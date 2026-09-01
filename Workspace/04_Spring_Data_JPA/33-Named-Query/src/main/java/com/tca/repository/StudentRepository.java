package com.tca.repository;

import com.tca.entity.Gender;
import com.tca.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    public List<Student> fetchByNameAndCity(String name, String city);

    public List<Student> fetchByCityAndGender(String city, Gender gender);
}
