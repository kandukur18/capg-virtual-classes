package com.capg.groups_contacts.exercise.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Groups")
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int groupId;
	private String groupName;
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "group")
	private Set<Contact> contacts;
	
	public Group()
	{
		
	}

	public Group(String groupName, String description, Set<Contact> contacts) {
		super();
		this.groupName = groupName;
		this.description = description;
		this.contacts = contacts;
	}



	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
  

	public Set<Contact> getContact() {
		return contacts;
	}

	public void setContact(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	
	
	
}
