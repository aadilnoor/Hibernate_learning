package com.hiber;

import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("project id runnning.....");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// Creating Table object of Student class
		Student student = new Student();
		student.setId(101);
		student.setName("AADIL");
		student.setCity("MUMBAI");

		//System.out.println(student);

		// Creating table object of address class

		Address address = new Address();
		address.setStreet("Wajid ali compound");
		address.setCity("Mumbai");
		address.setOpen(true);
		address.setAddedDate(new Date());
		address.setX(871.27);
		
		// Reading image
		/*
		 * FileInputStream file = new FileInputStream("src/main/java/Hibernate.png");
		 * byte[] data = new byte[file.available()]; file.read(data);
		 * address.setImage(data);
		 * 
		 */
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		session.save(student);
		session.save(address);
		// session.getTransaction().commit();
		transaction.commit();

		session.close();

		System.out.println("Done...");

	}
}
