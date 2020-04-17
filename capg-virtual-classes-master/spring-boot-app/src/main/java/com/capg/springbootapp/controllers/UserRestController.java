package com.capg.springbootapp.controllers;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.springbootapp.models.Person;

@RestController
@RequestMapping("/api")
public class UserRestController {
	
	@GetMapping("/users")
	public Person getUser() {
		   Person person=new Person("Mani", 101,
				   "nagireddymani090@gmail.com",LocalDate.of(1998, 04, 02), 22);
		return person;
	}
}