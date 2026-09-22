package com.tca.service;

import com.tca.entity.Student;

import java.util.Optional;

public interface StudentService {

    Student save(Student student);

    Optional<Student> getById(Long id);
}
