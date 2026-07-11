package com.tca.util;

import org.springframework.stereotype.Component;

@Component
public class StudentIdGenerator {
	
	private long counter;

	public String generateStudentId() {
		return "TCA-" + (++counter);
	}
	
	public String getLastGeneratedStudentId() {
		return ( counter == 0) ? null : "TCA-" + counter;
	}
}
