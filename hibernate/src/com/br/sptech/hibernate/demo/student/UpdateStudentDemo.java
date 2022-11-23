package com.br.sptech.hibernate.demo.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.br.sptech.hibernate.demo.student.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			Student student = session.get(Student.class, 8);
			
			student.setFirstName("Paulo");
			student.setLastName("Souza");
			student.setEmail("paulo@email.com");
			
			session.createQuery("update Student set email = 'email@email.com'").executeUpdate();
			
			session.getTransaction().commit();
		
		} finally {
			session.close();
		}
	}

}
