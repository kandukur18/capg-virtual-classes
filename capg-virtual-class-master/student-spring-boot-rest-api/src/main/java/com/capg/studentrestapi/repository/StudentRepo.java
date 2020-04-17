package com.capg.studentrestapi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.capg.studentrestapi.model.Student;

@Repository
public class StudentRepo {
	@PersistenceContext
	EntityManager em;
	
	public Student addStudent(Student student) {
		em.persist(student);
		return student;
	}
	
	public  Student getUser(int studentId) {
		return em.find(Student.class, studentId);
	}
	
}
