package com.capg.labbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.labbook.model.Trainee;

public interface TraineeDaoInterface extends JpaRepository<Trainee,Integer> {

}
