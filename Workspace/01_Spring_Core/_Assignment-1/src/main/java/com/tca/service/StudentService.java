package com.tca.service;

import java.util.List;

import com.tca.dto.StudentDTO;
import com.tca.entity.Student;

public interface StudentService {

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
	public abstract StudentDTO getById(String studentId);
	
	
	/**
	 * Get all students
	 * @return List containing all students, null otherwise
	 */
	public abstract List<StudentDTO> getAll();
	
	
}
