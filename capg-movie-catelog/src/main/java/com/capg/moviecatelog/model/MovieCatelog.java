package com.capg.moviecatelog.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class MovieCatelog {

	@Id
	private long id;
	private String movieName;
	public MovieCatelog() {
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public MovieCatelog(long id, String movieName) {
		super();
		this.id = id;
		this.movieName = movieName;
	}
	@Override
	public String toString() {
		return "MovieCatelog [id=" + id + ", movieName=" + movieName + "]";
	}
	
	
}
