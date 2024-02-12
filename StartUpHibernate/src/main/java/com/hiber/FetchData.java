package com.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();
		// get Student data Student class
		Student student = (Student) session.get(Student.class, 101);

		Address address = (Address) session.load(Address.class, 1);

		System.out.println(student);
		System.out.println(address.getStreet());

		session.close();
		factory.close();

	}
}
