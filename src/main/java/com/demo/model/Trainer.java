package com.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "trainer")
public class Trainer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name ="id")
	private int id; 
	
	@Column(name = "name")
	private String name; 
	
	@Column(name = "specailization")
	private String specailization;
	
	@OneToMany(mappedBy = "trainer",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH} )
	List<Course> course;
	
	
	public Trainer() {}

	public Trainer(String name, String specailization) {
		this.name = name;
		this.specailization = specailization;
	}

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

	public String getSpecailization() {
		return specailization;
	}

	public void setSpecailization(String specailization) {
		this.specailization = specailization;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Trainer [id=" + id + ", name=" + name + ", specailization=" + specailization + ", course=" + course
				+ "]";
	} 
}
