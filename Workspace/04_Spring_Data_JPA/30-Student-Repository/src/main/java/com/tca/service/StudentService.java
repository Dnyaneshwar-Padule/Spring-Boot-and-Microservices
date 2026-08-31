package com.tca.service;


import com.tca.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    public Long count();

    public boolean existsById(Integer id);

    public List<Student> findAll();

    public List<Student> findAllById(List<Integer> ids);

    public Optional<Student> findById(Integer id);

    public Student save(Student student);

    public List<Student> saveAll(List<Student> students);

    public void delete(Student student);

    public void deleteAll();

    public void deleteAll(List<Student> students);

    public void deleteAllById(List<Integer> ids);

    public void deleteById(Integer id);
}
