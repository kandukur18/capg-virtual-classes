package com.capg.springbootapp.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Person {
  
	private String userName;
	private int userId;
	private String emailId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private int age;
	
	public Person()
	{
			
	}
	public Person(String userName, int userId, String emailId, LocalDate date, int age) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.emailId = emailId;
		this.date = date;
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
