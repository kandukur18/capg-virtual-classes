package com.capg.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="trainee")
public class Trainee {

	
	 @Value("${trainee.Id}")
	 private int id;
	 @Value("${trainee.Name}")
	 private String name;
	 @Value("${trainee.Technology}")
	 private String technology;

	  @Autowired
	  private Trainer trainer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	 
	
	public void display()
	{
		System.out.println("Trainee Details ");
		System.out.println("-------------------------------------------------");
		System.out.println("Trainee ID          : "+id);
		System.out.println("Trainee Name        : "+name);
		System.out.println("Trainee Technology  : "+technology);
		System.out.println("Trainee Trainer     : "+trainer.getTrainerName());
		System.out.println("Trainee Trainer     : "+trainer.getExpertise());
		
	}
	  
}
