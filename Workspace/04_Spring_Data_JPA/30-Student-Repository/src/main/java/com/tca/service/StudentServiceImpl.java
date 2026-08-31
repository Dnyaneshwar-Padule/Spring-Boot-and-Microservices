package com.tca.service;

import com.tca.entity.Student;
import com.tca.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service("studentService")
public class StudentServiceImpl implements StudentService {

//    @Autowired
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public Long count() {
        return studentRepository.count();
    }

    @Override
    public boolean existsById(Integer id) {
        return studentRepository.existsById(id);
    }

    @Override
    public List<Student> findAll() {
        return (List<Student>)studentRepository.findAll();
    }

    @Override
    public List<Student> findAllById(List<Integer> ids) {
        return (List<Student>)studentRepository.findAllById(ids);
    }

    @Override
    public Optional<Student> findById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student save(Student student){
        return studentRepository.save(student);
    }

    @Override
    public List<Student> saveAll(List<Student> students) {
        return (List<Student>) studentRepository.saveAll(students);
    }

    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }

    @Override
    public void deleteAll(List<Student> students) {
        studentRepository.deleteAll(students);
    }

    @Override
    public void deleteAllById(List<Integer> ids) {
        studentRepository.deleteAllById(ids);
    }

    @Override
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

}
