package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		System.out.println("project is running...!");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		/*
		 * // creating question object Question question = new Question();
		 * question.setQuestionId(121); question.setQuestion("What is java ? ");
		 * 
		 * // creating answer object Answer answer1 = new Answer();
		 * answer1.setAnswerId(6876);
		 * answer1.setAnswer("Java is a programing language... ");
		 * answer1.setQuestion(question);
		 * 
		 * Answer answer2 = new Answer(); answer2.setAnswerId(123); answer2.
		 * setAnswer("With the help of java programing language we can create softwares..."
		 * ); answer2.setQuestion(question);
		 * 
		 * Answer answer3 = new Answer(); answer3.setAnswerId(124);
		 * answer3.setAnswer("java language has difffrent type of frameworks...  ");
		 * answer3.setQuestion(question);
		 * 
		 * List<Answer> list = new ArrayList<Answer>(); list.add(answer1);
		 * list.add(answer2); list.add(answer3);
		 * 
		 * question.setAnswers(list);
		 */

		// create session
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		// save data
		/*
		 * session.save(question); session.save(answer1); session.save(answer2);
		 * session.save(answer3);
		 */
		// fetching data
		
		Question q =(Question) session.get(Question.class, 121);
		System.out.println(q.getQuestionId());
		System.out.println(q.getQuestion());
		// is called lazy loading when need to print  System.out.println(q.getAnswers().size());
		
		// get answers 
		for (Answer a : q.getAnswers()) {
			System.out.println(a.getAnswer());
		}

		transaction.commit();
		factory.close();

	}
}
