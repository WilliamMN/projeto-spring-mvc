package com.br.sptech.hibernate.demo.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.br.sptech.hibernate.demo.student.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Student student = new Student("43w3", "qwe", "asfdasdd");
			
			session.beginTransaction();
			
			session.save(student);
			
			System.out.println(student);
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			Student doBanco = session.get(Student.class, student.getId());
			
			System.out.println(doBanco);
		
		} finally {
			session.close();
		}

	}

}
