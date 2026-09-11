package com.tca;

import com.tca.entity.Student;
import com.tca.util.Validator;

public class App {

	public static void main(String[] args) throws Exception{

		Student s = new Student();
		s.setName(null);
		s.setEmail("1234@email.com");
		s.setPhone("998877665");
	
		System.out.println(Validator.validate(s)); // false
		
		s.setPhone("9900990099");
		System.out.println(Validator.validate(s)); // false
		
		s.setEmail("athrva@gmail.com");
		System.out.println(Validator.validate(s)); // false
		
		s.setName("Athrva");
		System.out.println(Validator.validate(s)); // true
		
	}
}
