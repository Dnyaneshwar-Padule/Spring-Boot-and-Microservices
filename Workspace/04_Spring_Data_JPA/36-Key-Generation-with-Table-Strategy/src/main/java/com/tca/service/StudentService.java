package com.tca.service;

import com.tca.entity.Student;

import java.util.Optional;

public interface StudentService {

    public Student save(Student student);

    public Optional<Student> getById(Long id);
}
