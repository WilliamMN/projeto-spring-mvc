package com.sptech.springdemo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sptech.springdemo.mvc.entity.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {

		// cria um student
		Student theStudent = new Student();

		// adicionar o objeto de student no model
		theModel.addAttribute("student", theStudent);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		System.out.println(String.format("Nome: %s\nSobrenome: %s", student.getFirstName(), student.getLastName()));
		return "student-confirmation";
	}

}
