package com.capg.demo.healthcaresystemhome.dao;

import java.util.Date;

import com.capg.demo.healthcaresystemhome.model.DiagnosticCenter;
import com.capg.demo.healthcaresystemhome.model.DiagnosticTest;
import com.capg.demo.healthcaresystemhome.model.User;

public interface DaoInterface {

	public String addCenter(DiagnosticCenter center);
	public boolean removeCenter(DiagnosticCenter center);
	public String addDiagnosticTest(DiagnosticTest test);
	public boolean removeDiagnosticTest(DiagnosticTest test);
	public boolean approveAppointment();
	public Long makeAppointment(User user,DiagnosticCenter center,DiagnosticTest test,Date dateTime);
	public String register(User user);
	
}
