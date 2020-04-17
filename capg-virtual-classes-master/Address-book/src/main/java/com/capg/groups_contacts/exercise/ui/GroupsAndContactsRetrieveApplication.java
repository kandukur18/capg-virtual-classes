package com.capg.groups_contacts.exercise.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.capg.groups_contacts.exercise.models.Contact;
import com.capg.groups_contacts.exercise.models.Group;
import com.capg.groups_contacts.exercise.util.JPAUtil;

public class GroupsAndContactsRetrieveApplication {

	public static void main(String[] args) {
		EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		
		String querystr1="SELECT g FROM Group g";
		TypedQuery<Group> query1=em.createQuery(querystr1,Group.class);
		List<Group> dataList1=query1.getResultList();
		System.out.println("\nGroupId \t GroupName \t Description");
		System.out.println("---------------------------------------------------------");
		for(Group c:dataList1)
		{
			System.out.println(c.getGroupId()+"\t\t"+c.getGroupName()+"\t\t"+c.getDescription());
		}
		
		String querystr2="SELECT c FROM Contact c";
		TypedQuery<Contact> query2=em.createQuery(querystr2,Contact.class);
		List<Contact> dataList2=query2.getResultList();
		System.out.println("\nContactId \t FirstName \t LastName \t MobileNumber \t Email");
		System.out.println("------------------------------------------------------------------------------");
		for(Contact c:dataList2)
		{
		    System.out.println(c.getContactId()+"\t\t"+c.getFirstName()+"\t"+c.getLastName()+"\t"+c.getMobileNumber()+"\t"+c.geteMail());	
		}
		
		em.getTransaction().commit();
		System.out.println("\nRetrieved");
		JPAUtil.shutdown();

	}

}
