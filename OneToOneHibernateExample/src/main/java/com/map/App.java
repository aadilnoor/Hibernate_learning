package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// creating Question object
		Question question = new Question();
		question.setQuestionId(121);
		question.setQuestion("What is java ?");

		// creating Answer object
		Answer answer = new Answer();
		answer.setAnswerId(343);
		answer.setAnswer("java is a programing language...");
		answer.setQuestion(question);

		question.setAnswer(answer);

		// creating Question object
		Question question1 = new Question();
		question1.setQuestionId(122);
		question1.setQuestion("What is eclipse ?");

		// creating Answer object
		Answer answer1 = new Answer();
		answer1.setAnswerId(344);
		answer1.setAnswer("eclipse is a tool it is use to write java code...");
		answer1.setQuestion(question1);

		question1.setAnswer(answer1);
		

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(question);
		session.save(question1);
		session.save(answer);
		session.save(answer1);

		transaction.commit();
		
		// fetching data 
		Question question2 = session.get(Question.class, 121);
		System.out.println(question2.getQuestion());
		System.out.println(question2.getAnswer().getAnswer());

		factory.close();
		session.close();
	}
}
