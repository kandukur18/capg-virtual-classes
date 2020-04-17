package com.capg.springbootapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.capg.springbootapp.models.Person;
import com.capg.springbootapp.service.PersonService;

@RestController
public class TestController {

	@Autowired
	private PersonService personService;
	
	@GetMapping("/")
	public ModelAndView sayHello()
	{
		return new ModelAndView("view.jsp","person",new Person());
	}
	
	@PostMapping("/add")
	public ModelAndView showOutputPage(@ModelAttribute Person person)
	{
		
		person.setAge(personService.computeAge(person.getDate()	));
		return new ModelAndView("OutputPage.jsp","person",person);
	}	
}
