package com.br.sptech.hibernate.onetoone.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.br.sptech.hibernate.onetoone.demo.entity.Instructor;
import com.br.sptech.hibernate.onetoone.demo.entity.InstructorDetail;

public class DeleteInstructorDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			InstructorDetail id = session.get(InstructorDetail.class, 4);
			
			id.getInstructor().setInstructorDetail(null);
			session.delete(id);
			
			session.getTransaction().commit();
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
