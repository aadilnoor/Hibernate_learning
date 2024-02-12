package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		System.out.println("project is running !");

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

		Answer answer1 = new Answer();
		answer1.setAnswerId(344);
		answer1.setAnswer("With the help of java programing we can create softwares...");
		answer1.setQuestion(question);

		Answer answer2 = new Answer();
		answer2.setAnswerId(345);
		answer2.setAnswer("java has different types of frame works...");
		answer2.setQuestion(question);

		List<Answer> list = new ArrayList<Answer>();
		list.add(answer);
		list.add(answer1);
		list.add(answer2);

		question.setAnswers(list);

		// session create
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		// save
		session.save(question);
		session.save(answer);
		session.save(answer1);
		session.save(answer2);

		transaction.commit();

		// fetching data
		/*
		 * Question ques = (Question) session.get(Question.class, 121);
		 * System.out.println(ques.getQuestion());
		 * 
		 * for (Answer a : ques.getAnswers()) { System.out.println(a.getAnswer()); }
		 */

		factory.close();
		session.close();
	}
}
