package com.tca.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tca.entity.Student;
import com.tca.util.StudentIdGenerator;

@Component
public class StudentRepositoryImpl implements StudentRepository {

	
	@Autowired
	/*
	 * There will be singleton object of HashMap<> inside SpringContainer
	 */
	private HashMap<String, Student> studentStore;
	
	@Autowired
	private StudentIdGenerator studentIdGenerator;
	
	@Override
	public String save(Student student) {
		studentStore.put(studentIdGenerator.generateStudentId(), student);
		return studentIdGenerator.getLastGeneratedStudentId();
	}

	@Override
	public Student getById(String studentId) {
		return studentStore.get(studentId);
	}

	@Override
	public Set<Entry<String,Student>> getAllEntries() {
		return studentStore.entrySet();
	}

}
