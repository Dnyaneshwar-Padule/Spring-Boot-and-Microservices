package com.tca.dto;

public record StudentDTO(
		String studentId, 
		String name,
		String city, 
		Double per
		) {

	@Override
	public String toString() {
		return "StudentDTO [studentId=" + studentId + ", name=" + name + ", city=" + city + ", per=" + per + "]";
	}
}
