package in.tp.jpa.hib.demo.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import in.tp.jpa.hib.demo.models.example1.Employee;
import in.tp.jpa.hib.demo.models.onetoMany.Course;
import in.tp.jpa.hib.demo.util.JPAUtil;

public class Example7TypedQrys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		String qryString = "SELECT c FROM Course c";
		Query qry= em.createQuery(qryString);
		
		List<Course> courseList=qry.getResultList();
		for(Course c : courseList) {
			System.out.println(c.getcId() + "\t" + c.getcName());
		}
		TypedQuery<Course> courseQry =em.createQuery(qryString,Course.class);
		
		List<Course> courseList2=courseQry.getResultList();
		for(Course c : courseList2) {
			System.out.println(c.getcId() + "\t" + c.getcName());
		}
		
		//named parameters by ordinals..
		
        TypedQuery<Employee> empQry2 =em.createQuery(
        		"SELECT e FROM Employee e WHERE e.basic BETWEEN ?1 AND ?2",Employee.class);
		empQry2.setParameter(1, 4500.0);
		empQry2.setParameter(2, 9500.0);
		List<Employee> emps2=empQry2.getResultList();
		for(Employee e : emps2) {
			System.out.println(e.getEmpId() + "\t" + e.getEmpName() + "\t" + e.getBasic());
		}
		
		TypedQuery<Employee> empQry3 =em.createNamedQuery("empbasic", Employee.class);
		empQry2.setParameter("lbound", 4500.0);
		empQry2.setParameter("ubound", 9500.0);
		List<Employee> emps3=empQry3.getResultList();
		for(Employee e : emps3) {
			System.out.println(e.getEmpId() + "\t" + e.getEmpName() + "\t" + e.getBasic());
		}
		em.close();
	}
	

}
