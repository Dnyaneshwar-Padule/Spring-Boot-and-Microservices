package com.tca.service;

import com.tca.entity.Student;
import com.tca.repository.StudentRepository;
import org.springframework.stereotype.Service;


@Service("studentService")
public class StudentServiceImpl implements StudentService {

//    @Autowired
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student){
        return studentRepository.save(student);
    }
}
