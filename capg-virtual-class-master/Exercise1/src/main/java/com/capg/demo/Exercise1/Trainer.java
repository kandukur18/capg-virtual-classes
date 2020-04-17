package com.capg.demo.Exercise1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("trainer")
public class Trainer {
    
	@Value("${trainer.Name}")
	private String trainerName;
	@Value("${trainer.Expertise}")
	private String expertise;
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	
	
	
}
