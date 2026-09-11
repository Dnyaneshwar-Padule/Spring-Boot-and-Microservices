package com.tca.entity;

import com.tca.annotation.Validate;

public class Student {

	@Validate(required = true, minLen = 2, maxLen = 64)
	private String name;
	
	@Validate(minLen = 15, maxLen = 255)
	private String email;
	
	@Validate(minLen = 10, maxLen = 10)
	private String phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
