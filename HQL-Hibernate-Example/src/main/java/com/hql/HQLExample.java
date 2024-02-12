package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLExample {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();

		String query = "from Student as s where s.city=:c and s.name=:n";
		Query query2 = session.createQuery(query);

		query2.setParameter("c", "PUNE");
		query2.setParameter("n", "SAMEER");

		// single result (unique)
		// multiple result (list)
		// query2.uniqueResult();
		List<Student> list = query2.list();

		for (Student student : list) {
			System.out.println(student.getName() + " : " + student.getCertificate().getCourse());
		}

		System.out.println("---------------------------------------------------------------------");

		Transaction transaction = session.beginTransaction();
		// Delete Query
		/*
		 * Query query3 =
		 * session.createQuery("delete from Student as s where s.city=:c");
		 * query3.setParameter("c", "pune");
		 * 
		 * int i = query3.executeUpdate(); System.out.println("Deleted");
		 * System.out.println(i);
		 */

		// Update Query
		// use alias Query query3 = session.createQuery("update Student as s set s.city=:c where s.name=:n");
		Query query3 = session.createQuery("update Student set city=:c where name=:n");
		query3.setParameter("c", "PUNE");
		query3.setParameter("n", "SAMEER");
		int i = query3.executeUpdate();
		System.out.println("object updated");
		System.out.println(i);
		transaction.commit();
	}
	
	
}
