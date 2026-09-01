package com.tca.service;

import com.tca.entity.Gender;
import com.tca.entity.Student;
import com.tca.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findByNameAndCity(String name, String city) {
        return studentRepository.fetchByNameAndCity(name, city);
    }

    @Override
    public List<Student> findByCityAndGender(String city, Gender gender) {
        return studentRepository.fetchByCityAndGender(city, gender);
    }
}
