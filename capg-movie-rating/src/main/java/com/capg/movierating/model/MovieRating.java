package com.capg.movierating.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MovieRating {

	@Id
	private long id;
	private double rating;
	public MovieRating() {
		// TODO Auto-generated constructor stub
	}
	
}
