package com.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedClass {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Student student1 = new Student();
		student1.setId(11);
		student1.setName("FAIZ");
		student1.setCity("MUMBAI");

		Certificate certificate1 = new Certificate();
		certificate1.setCourse("JAVA PROGRAMING");
		certificate1.setDuration("2 MONTH");

		student1.setCertificate(certificate1);

		Student student2 = new Student();
		student2.setId(12);
		student2.setName("SAMEER");
		student2.setCity("PUNE");

		Certificate certificate2 = new Certificate();
		certificate2.setCourse("C PROGRAMING");
		certificate2.setDuration("1.5 MONTH");

		student2.setCertificate(certificate2);
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		//Object Save
		session.save(student1);
		session.save(student2);
		
		transaction.commit();
		factory.close();
		session.close();
	}
}
