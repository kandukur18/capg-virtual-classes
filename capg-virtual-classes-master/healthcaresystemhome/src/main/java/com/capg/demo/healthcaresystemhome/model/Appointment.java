package com.capg.demo.healthcaresystemhome.model;

import java.util.Date;

public class Appointment {

	//fields
	User user;
	Long appointmentId;
	DiagnosticTest test;
	Date dateTime;
	Boolean approved=false;
	//Constructors
	public Appointment() {
		super();
	}

	public Appointment(User user, Long appointmentId, DiagnosticTest test, Date dateTime, Boolean approved) {
		super();
		this.user = user;
		this.appointmentId = appointmentId;
		this.test = test;
		this.dateTime = dateTime;
		this.approved = approved;
	}

	//Getter and setter methods
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public DiagnosticTest getTest() {
		return test;
	}

	public void setTest(DiagnosticTest test) {
		this.test = test;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	//toString method
	@Override
	public String toString() {
		return "Appointment [user=" + user + ", appointmentId=" + appointmentId + ", test=" + test + ", dateTime="
				+ dateTime + ", approved=" + approved + "]";
	}
	
    															
	
	
}
