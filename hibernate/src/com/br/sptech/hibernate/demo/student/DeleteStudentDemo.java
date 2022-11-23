package com.br.sptech.hibernate.demo.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

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
			
			session.delete(student);
			session.createQuery("delete from Student where id=6").executeUpdate();
			
			session.getTransaction().commit();
		
		} finally {
			session.close();
		}
	}

}
