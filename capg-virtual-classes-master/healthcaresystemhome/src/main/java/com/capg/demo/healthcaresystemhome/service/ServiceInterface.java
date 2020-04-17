package com.capg.demo.healthcaresystemhome.service;

import java.util.Date;

import com.capg.demo.healthcaresystemhome.model.DiagnosticCenter;
import com.capg.demo.healthcaresystemhome.model.DiagnosticTest;
import com.capg.demo.healthcaresystemhome.model.User;

public interface ServiceInterface {

	public String addCenter(DiagnosticCenter center);
	public boolean removeCenter(DiagnosticCenter center);
	public String addDiagnosticTest(DiagnosticTest test);
	public boolean removeDiagnosticTest(DiagnosticTest test);
	public boolean approveAppointment();
	public Long makeAppointment(User user,DiagnosticCenter center,DiagnosticTest test,Date dateTime);
	public String register(User user);
	public boolean validateUserName(String userName);
	public boolean validateUserPassword(String userPassword);
	public boolean validateMobileNumber(Long ContactNo);
	public boolean validateEmail(String eMail);
	
}