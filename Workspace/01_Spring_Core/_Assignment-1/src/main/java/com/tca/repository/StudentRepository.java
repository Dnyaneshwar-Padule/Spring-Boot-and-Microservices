package com.tca.repository;

import java.util.Map.Entry;
import java.util.Set;

import com.tca.entity.Student;

public interface StudentRepository {

	/**
	 * To save a student
	 * @param student Student to save
	 * @return studentId on success, null otherwise 
	 */
	public abstract String save(Student student);
	
	
	/**
	 * Get a Student by his/her ID
	 * @param studentId the ID of a Student
	 * @return Student object on success, null otherwise
	 */
	public abstract Student getById(String studentId);
	
	
	/**
	 * Get all students
	 * @return List containing all students, null otherwise
	 */
	public abstract Set<Entry<String,Student>> getAllEntries();
	
}
