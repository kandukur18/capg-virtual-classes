package com.capg.demo.healthcaresystemhome.model;

import java.util.ArrayList;
import java.util.List;

public class DiagnosticCenter {

	//fields
	String centerName;
	String centerId;
	List<DiagnosticTest> listOfTests;
	List<Appointment> appointmentList;
	
	//Constructors
	public DiagnosticCenter() {
		super();
	}

	public DiagnosticCenter(String centerName, String centerId, List<DiagnosticTest> listOfTests,
			List<Appointment> appointmentList) {
		super();
		this.centerName = centerName;
		this.centerId = centerId;
		this.listOfTests = listOfTests;
		this.appointmentList = appointmentList;
	}

	//Getter and Setter Methods
	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getCenterId() {
		return centerId;
	}

	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}

	public List<DiagnosticTest> getListOfTests() {
		return  listOfTests;
	}

	public void setListOfTests(List<DiagnosticTest> listOfTests) {
		this.listOfTests = listOfTests;
	}

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

	
	//toString Methods
	@Override
	public String toString() {
		return "DiagnosticCenter [centerName=" + centerName + ", centerId=" + centerId + ", listOfTests=" + listOfTests
				+ ", appointmentList=" + appointmentList + "]";
	}
	
	
	
}
