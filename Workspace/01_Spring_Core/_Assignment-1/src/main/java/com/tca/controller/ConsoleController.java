package com.tca.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tca.dto.StudentDTO;
import com.tca.entity.Student;
import com.tca.service.StudentService;

@Component
public class ConsoleController {


	@Autowired
	private BufferedReader reader;
	
	@Autowired
	private StudentService studentService;
	
	public void start() { 
		while(true) {
			
			showMenu();
			
			switch(acceptChoice()) {
				case 1:
						// add
						add();
						break;
				case 2:
						// search
						search();
						break;
				case 3:
						// show all
						displayAll();
						break;
				case 4:
						System.out.println("Exiting...");
						return;
				default:
						System.out.println("Invalid choice ! Please try again.");
			}
		
			System.out.println("==============================================================\n");
		}
	}
	
	
	private void showMenu() {
		System.out.println("****** Menu ******\n"
				+ "1. Add Student\n"
				+ "2. Search Student\n"
				+ "3. See all Students\n"
				+ "4. Exit");
	}
	
	private int acceptChoice() {
		try {
			System.out.print("Enter : ");
			return Integer.parseInt(reader.readLine());
		}catch(NumberFormatException ne) {
			System.out.println("Invalid input ! Please try again.");
			return acceptChoice();
		}catch(IOException ie) {
			System.out.println("Unable to read input !");
			return 4;
		}
	}
	
	private void add() {
		try {
			Student s = new Student();
			
			System.out.print("Enter name : ");
			s.setName( reader.readLine() );
			
			System.out.print("Enter city : ");
			s.setCity(reader.readLine());
			
			System.out.print("Enter per  : ");
			s.setPer( Double.parseDouble( reader.readLine() ) );
		
			String studentId = studentService.save(s);
			
			if(studentId == null) {
				System.out.println("Unable to save student !");
			}
			else {
				System.out.println("Student is saved with ID : " + studentId);
			}
		}
		catch(NumberFormatException ne) {
			System.out.println("Invalid input ! Please try again.");
		}
		catch(IOException ie) {
			System.out.println("Unable to read input ! Please try agian.");
		}
		catch(Exception e) {
			System.out.println("Something went wrong.");
		}
	}
	
	private void search() {
		try {
			System.out.print("Enter the Student ID : ");
			StudentDTO studentDTO = studentService.getById( reader.readLine().trim() );
			
			if(studentDTO != null)
				System.out.println(studentDTO.toString());
			else
				System.out.println("Student not found !");
		}
		catch(IOException ie) {
			System.out.println("Unable to read input ! Please try again.");
		}
		catch(Exception e) {
			System.out.println("Something went wrong !");
		}
	}
	
	private void displayAll() {
		try {
			List<StudentDTO> studentList = studentService.getAll();
			
			if(studentList == null) {
				System.out.println("Something went wrong while displaying student records, please try again.");
				return;
			}
			
			if(studentList.size() == 0) {
				System.out.println("No Student records found !");
				return;
			}
			
			for(StudentDTO studentDTO: studentList) {
				//System.out.println("Student ID   : " + studentDTO.studentId());
				//System.out.println("Student name : " + studentDTO.name());
				//System.out.println("Student city : " + studentDTO.city());
				//System.out.println("Student per  : " + studentDTO.per());
				//System.out.println("----------------------------------------------------------------------------");
				System.out.println(studentDTO.toString());
			}
			
		}
		catch(Exception e) {
			System.out.println("Something went wrong while displaying student records, please try again.");
		}
	}
}
