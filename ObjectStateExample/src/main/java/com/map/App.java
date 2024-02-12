package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		System.out.println("Project is running !");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// creating object
		Students students = new Students();
		students.setStudentId(101);
		students.setName("AADIL");
		students.setCity("Mumbai");
		students.setPhoneNumber(8978967856L);
		students.setPincode(400072);

		Course course = new Course();
		course.setCourseName("BCA");
		course.setYear("2024");
		course.setDuration("3 YEAR");

		students.setCourse(course);

		// student : transient state

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		session.save(students);
		// student : persistent state
		students.setName("Noor");
		

		transaction.commit();
		
		session.close();
		// student : detached state 
		students.setName("khan");
		System.out.println(students.getName());
		
		factory.close();

	}
}
