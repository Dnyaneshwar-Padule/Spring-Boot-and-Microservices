package com.tca.service;

import com.tca.entity.Student;

import java.util.Optional;
import java.util.UUID;

public interface StudentService {

    public Student save(Student s);

    public Optional<Student> getById(UUID id);
}
