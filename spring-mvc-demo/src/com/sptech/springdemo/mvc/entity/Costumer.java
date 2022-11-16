package com.sptech.springdemo.mvc.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sptech.springdemo.mvc.validation.CourseCode;

public class Costumer {
	@NotNull
	@Size(min = 1, message = "is required")
	private String firstName;

	@NotNull
	@Size(min = 1, message = "is required")
	private String lastName;

	@NotNull
	@Min(value = 0, message = "must be greater than or equal to zero")
	@Max(value = 10, message = "must be greater than or equal to ten")
	private Integer freePasses;

	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
	private String postalCode;

	@CourseCode(value = { "LUV", "STA" }, message = "must start with LUV or STA")
	private String courseCode;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

}
