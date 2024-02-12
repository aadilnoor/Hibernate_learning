package com.map;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Employee emp1 = new Employee();
		Employee emp2 = new Employee();

		emp1.setEid(12);
		emp1.setEname("Aadil");

		emp2.setEid(13);
		emp2.setEname("Yasir");

		Projects ps1 = new Projects();
		Projects ps2 = new Projects();

		ps1.setPid(769);
		ps1.setProjectname("Library Management System");

		ps2.setPid(8587);
		ps2.setProjectname("ChatBot");

		ArrayList<Employee> list1 = new ArrayList<Employee>();
		ArrayList<Projects> list2 = new ArrayList<Projects>();

		list1.add(emp1);
		list1.add(emp2);

		list2.add(ps1);
		list2.add(ps2);
		emp1.setProjects(list2);
		ps2.setEmps(list1);

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		session.save(emp1);
		session.save(emp2);
		session.save(ps1);
		session.save(ps2);

		transaction.commit();

		factory.close();

	}
}
