package com.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Students {

	@Id
	@Column(name = "student_id")
	private int studentId;
	
	@Column(name = "student_name")
	private String Name;
	
	private String city;
	
	private Course course;
	
	private int pincode;
	@Column(name = "phone_number")
	private long phoneNumber;
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Students(int studentId, String name, String city, int pincode, long phoneNumber) {
		super();
		this.studentId = studentId;
		Name = name;
		this.city = city;
		this.pincode = pincode;
		this.phoneNumber = phoneNumber;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
}
