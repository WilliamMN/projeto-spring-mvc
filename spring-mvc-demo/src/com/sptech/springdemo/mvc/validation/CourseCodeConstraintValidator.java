package com.sptech.springdemo.mvc.validation;

import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;

	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraint) {
		boolean result = true;

		if (Objects.nonNull(theCode)) {
			result = theCode.startsWith(coursePrefix);
		}

		return result;
	}

}
