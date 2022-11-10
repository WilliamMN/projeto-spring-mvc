package com.sptech.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class) // quem vai validar esta anotação
@Target({ElementType.METHOD, ElementType.FIELD}) // que tipo de elemento pode receber esta anotação
@Retention(RetentionPolicy.RUNTIME) // define quanto tempo ou em qual momento sera mantido em execução
public @interface CourseCode {
	
	// define o padrao de codigo
	public String value() default "LUV";
	
	// define o padrao de message
	public String message() default "must start with LUV";
	
	// define o padrao de grupos
	public Class<?>[] groups() default {};
	
	// define o padrao a resposta
	public Class<? extends Payload>[] payload() default {};
}
