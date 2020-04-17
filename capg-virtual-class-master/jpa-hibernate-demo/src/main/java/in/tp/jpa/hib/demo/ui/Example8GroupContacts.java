package in.tp.jpa.hib.demo.ui;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import in.tp.jpa.hib.demo.models.groupcontact.Contact;
import in.tp.jpa.hib.demo.models.groupcontact.Group;
import in.tp.jpa.hib.demo.util.JPAUtil;

public class Example8GroupContacts {
	
	public static void main(String[] args) {
		Group mca = new Group(111,"Family",new TreeSet<Contact>());
		Group mba = new Group(222,"Work",new TreeSet<Contact>());
		
		mca.getContacts().add(new Contact(1,"MOM", null,"9858547626", "satyavani@mail.com", "8/8/76","hyderabad", mca));
		mca.getContacts().add(new Contact(2,"DAD", null,"9865235744", "mohanrao@gmail.com", "3/6/72", "hyderabad", mca));
		mca.getContacts().add(new Contact(3,"BROther",null,"9521457863", "chaithu@gmail.com","4/5/96", "hyderabad", mca));
		
		mba.getContacts().add(new Contact(11, "Bhargav","vsv","9858547626", "bharagav@mail.com", "10/3/99","h.no:2,road:2,balangar,hyd", mba));
		mba.getContacts().add(new Contact(12, "Charan","tutta","9865235744", "charan@gmail.com", "20/3/99", "h.no:5,roadno:1,gangaram,hyd", mba));
		mba.getContacts().add(new Contact(13,"Nikhil","v","9521457863", "nikhil@gmail.com","4/5/99", "h.no:454,lingampally,bhel,hyd", mba));
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction txn=em.getTransaction();
		
		txn.begin();
		em.persist(mca);
		em.persist(mba);
		txn.commit();
		
		JPAUtil.shutdown();
	}

}
