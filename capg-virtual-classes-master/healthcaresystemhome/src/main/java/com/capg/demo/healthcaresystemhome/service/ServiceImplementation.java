package com.capg.demo.healthcaresystemhome.service;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capg.demo.healthcaresystemhome.dao.DaoImplementation;
import com.capg.demo.healthcaresystemhome.dao.DaoInterface;
import com.capg.demo.healthcaresystemhome.model.DiagnosticCenter;
import com.capg.demo.healthcaresystemhome.model.DiagnosticTest;
import com.capg.demo.healthcaresystemhome.model.User;

public class ServiceImplementation implements ServiceInterface {

	DaoInterface daoInterface=new DaoImplementation();
	
	public String addCenter(DiagnosticCenter center) {
		return daoInterface.addCenter(center);
	}

	public boolean removeCenter(DiagnosticCenter center) {
		return daoInterface.removeCenter(center);
	}

	public String addDiagnosticTest(DiagnosticTest test) {
		return daoInterface.addDiagnosticTest(test);
	}

	public boolean removeDiagnosticTest(DiagnosticTest test) {
		return daoInterface.removeDiagnosticTest(test);
	}

	public boolean approveAppointment() {
		return daoInterface.approveAppointment();
	}

	public Long makeAppointment(User user, DiagnosticCenter center, DiagnosticTest test, Date dateTime) {
		return daoInterface.makeAppointment(user, center, test, dateTime);
	}

	public String register(User user) {
		return daoInterface.register(user);
	}

	public boolean validateUserName(String userName) {
	    Pattern pattern=Pattern.compile("[A-Z][a-zA-z0-9]{6,30}");
	    Matcher matcher=pattern.matcher(userName);
	    if(matcher.find() && matcher.group().equals(userName))
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;	
	    }
		
	}

	public boolean validateUserPassword(String userPassword) {
		
		Pattern pattern=Pattern.compile("[0-9]+[a-z]+[A-Z]+[!@#$]+");
		Matcher matcher=pattern.matcher(userPassword);
		if(matcher.find() && matcher.group().contentEquals(userPassword))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	public boolean validateMobileNumber(Long contactNo) {
		Pattern pattern=Pattern.compile("[6789][0-9]{9}");
		Matcher matcher=pattern.matcher(Long.toString(contactNo));
		if(matcher.find() && matcher.group().equals(Long.toString(contactNo)))
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	public boolean validateEmail(String eMail) {
		Pattern pattern =Pattern.compile("[a-zA-z][a-zA-Z0-9._]*[@]gmail.com");
		Matcher matcher=pattern.matcher(eMail);
		if(matcher.find() && matcher.group().contentEquals(eMail))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

}
