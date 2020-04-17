package in.tp.jpa.hib.demo.ui;

import java.util.Scanner;

import javax.persistence.EntityManager;

import in.tp.jpa.hib.demo.models.example1.Employee;
import in.tp.jpa.hib.demo.util.JPAUtil;

public class Example1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// Create an emp object
		Employee e = new Employee();
		System.out.print("EmpId: ");
		e.setEmpId(scan.nextInt());
		System.out.print("EName: ");
		e.setEmpName(scan.next());
		System.out.print("Basic: ");
		e.setBasic(scan.nextDouble());

		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();

		System.out.println("Emp Saved!");
		JPAUtil.shutdown();
		scan.close();
	}
}
