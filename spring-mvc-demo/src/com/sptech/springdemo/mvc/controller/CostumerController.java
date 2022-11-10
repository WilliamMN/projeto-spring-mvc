package com.sptech.springdemo.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sptech.springdemo.mvc.entity.Costumer;

@Controller
@RequestMapping("/costumer")
public class CostumerController {

	@InitBinder
	public void initBinder(WebDataBinder theWebDataBinder) {
		StringTrimmerEditor theStringTrimmerEditor = new StringTrimmerEditor(true);

		theWebDataBinder.registerCustomEditor(String.class, theStringTrimmerEditor);
	}

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {

		theModel.addAttribute("costumer", new Costumer());

		return "costumer-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("costumer") Costumer costumer, BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {
			return "costumer-form";
		}

		return "costumer-confirmation";
	}

}
