package com.capg.demo.healthcaresystemhome.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.capg.demo.healthcaresystemhome.dao.DaoImplementation;

public class User {

	//fields
	String userId;
	String userPassword;
	String userName;
	Long contactNo;
	String userRole="Customer";
	String emailId;
	
	
	//Constructors
	public User() {
		super();
	}
	public User(String userId, String userPassword, String userName, Long contactNo, String userRole, String emailId) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.contactNo = contactNo;
		this.userRole = userRole;
		this.emailId = emailId;
	}

	//Getter and setter methods
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	//toString Method
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName + ", contactNo="
				+ contactNo + ", userRole=" + userRole + ", emailId=" + emailId +  "]";
	}
	
	
	
	
	
}
