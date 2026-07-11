package com.tca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tca.dto.StudentDTO;
import com.tca.entity.Student;
import com.tca.repository.StudentRepository;

@Component
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public String save(Student student) {
		if(student == null)
			return null;
		return studentRepository.save(student);
	}

	@Override
	public StudentDTO getById(String studentId) {
		if(studentId == null || studentId.isBlank())
			return null;
		
		Student student = studentRepository.getById(studentId);
		
		if(student == null)
				return null;
		
		return new StudentDTO(
				studentId,
				student.getName(),
				student.getCity(),
				student.getPer()
				);
	}

	@Override
	public List<StudentDTO> getAll() {
		try {
			Set<Entry<String,Student>> studentEntrySet = studentRepository.getAllEntries();
			List<StudentDTO> studentList = new ArrayList<>();
			
			for(Entry<String,Student> studentEntry : studentEntrySet ) {
				studentList.add(new StudentDTO(
							studentEntry.getKey(),
							studentEntry.getValue().getName(),
							studentEntry.getValue().getCity(),
							studentEntry.getValue().getPer()
						));
			}
			
			return studentList;
		}
		catch(Exception e) {
			return null;
		}
	}

}
