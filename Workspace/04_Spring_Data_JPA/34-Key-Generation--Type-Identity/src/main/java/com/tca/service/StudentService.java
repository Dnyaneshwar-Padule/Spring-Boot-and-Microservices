package com.tca.service;

import com.tca.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    public Student save(Student s);

    public Optional<Student> geById(Long id);

    public List<Student> getAll();
}
