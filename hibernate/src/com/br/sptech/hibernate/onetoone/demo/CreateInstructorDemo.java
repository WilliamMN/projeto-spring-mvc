package com.br.sptech.hibernate.onetoone.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.br.sptech.hibernate.onetoone.demo.entity.Instructor;
import com.br.sptech.hibernate.onetoone.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Instructor i1 = new Instructor("William", "Marques", "will@email.com", new InstructorDetail("youtube@will", "rock"));
			Instructor i2 = new Instructor("Manoel", "Almeida", "mano@email.com", null);
			
			session.save(i1);
			session.save(i2);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
