package com.capg.groups_contacts.exercise.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Contacts")
public class Contact implements Comparable<Contact> {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int contactId;
	private String firstName;
	private String lastName;
	private long mobileNumber;
	private String eMail;
	private String DOB;
	private String addressLine1;
	private String addressLine2;
	
	@ManyToOne
	@JoinColumn(name = "groudid")
	private Group group;
	
	public Contact()
	{
		
	}

	public Contact(String firstName, String lastName, long mobileNumber, String eMail, String dOB,
			String addressLine1, String addressLine2, Group group) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.eMail = eMail;
		this.DOB = dOB;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.group = group;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		this.DOB = dOB;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", eMail=" + eMail + ", DOB=" + DOB + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", group=" + group + "]";
	}

	public int compareTo(Contact o) {
		return (this.contactId<o.contactId?-1:(this.contactId>o.contactId?1:0));
	}

	
	
	
}
