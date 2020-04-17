package com.capg.studentrestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.studentrestapi.exceptions.StudentNotFoundException;
import com.capg.studentrestapi.model.Student;
import com.capg.studentrestapi.repository.StudentJpaRepo;

@Service
public class StudentService {
	
	@Autowired(required = true)
	StudentJpaRepo studentRepo;

	public List<Student> getListOfStudents(){
      	return studentRepo.findAll();
	}
	public Student getStudent(int studentId) {
		if(!studentRepo.existsById(studentId)) {
			throw new StudentNotFoundException("student with id : ["+studentId+"] Not Found"); 
		}
		return studentRepo.getOne(studentId);
	}
	@Transactional
	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}	
	@Transactional
	public boolean deleteStudent(int studentId) {
		studentRepo.deleteById(studentId);
		return !studentRepo.existsById(studentId);
	}
	@Transactional
	public Student updateStudent(Student newStudentData) {
		Student student=studentRepo.getOne(newStudentData.getStudentId());		
		student.setDob(newStudentData.getDob());
		student.setStudentName(newStudentData.getStudentName());
		studentRepo.save(student);
		return student;

}
}
