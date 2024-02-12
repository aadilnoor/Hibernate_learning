package com.map;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Course {

	@Column(name = "course_name")
	private String courseName;
	private String year;
	private String duration;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(String courseName, String year, String duration) {
		super();
		this.courseName = courseName;
		this.year = year;
		this.duration = duration;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
}
