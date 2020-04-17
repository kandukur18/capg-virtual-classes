package com.capg.springbootapp.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

	@Override
	public int computeAge(LocalDate date) {
		LocalDate today=LocalDate.now();
		int age=today.getYear()-date.getYear();
		return age;
	}

}
