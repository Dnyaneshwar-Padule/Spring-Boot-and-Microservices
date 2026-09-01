package com.tca.service;

import com.tca.entity.Gender;
import com.tca.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> findByNameAndCity(String name, String city);

    public List<Student> findByCityAndGender(String city, Gender gender);

}
