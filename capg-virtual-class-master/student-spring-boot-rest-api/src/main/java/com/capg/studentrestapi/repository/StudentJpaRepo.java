package com.capg.studentrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.studentrestapi.model.Student;
public interface StudentJpaRepo extends JpaRepository<Student, Integer>{

}
