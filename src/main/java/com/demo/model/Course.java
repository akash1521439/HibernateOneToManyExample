package com.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name="course_name")
	private String courseName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "trainer_id")
	private Trainer trainer;
	
	public Course() {
		
	}
	public Course(String courseName) {
		this.courseName = courseName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", trainer=" + trainer + "]";
	}
	
	
}
