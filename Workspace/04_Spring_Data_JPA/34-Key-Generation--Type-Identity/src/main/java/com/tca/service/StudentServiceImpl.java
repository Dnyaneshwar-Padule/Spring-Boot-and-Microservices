package com.tca.service;

import com.tca.entity.Student;
import com.tca.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("studentService")
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student s) {
        return studentRepository.save(s);
    }

    @Override
    public Optional<Student> geById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}
