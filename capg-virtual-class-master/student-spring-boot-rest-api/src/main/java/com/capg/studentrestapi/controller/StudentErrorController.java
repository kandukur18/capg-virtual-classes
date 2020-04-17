package com.capg.studentrestapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.studentrestapi.exceptions.StudentNotFoundException;

@ControllerAdvice
@RestController
public class StudentErrorController {

	@ExceptionHandler(StudentNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User Not Found" , code = HttpStatus.NOT_FOUND)
	public void handleUserNotFoundException() {
		
}
}
