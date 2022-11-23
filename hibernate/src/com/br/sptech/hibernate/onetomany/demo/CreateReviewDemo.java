package com.br.sptech.hibernate.onetomany.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.br.sptech.hibernate.onetomany.demo.entity.Course;
import com.br.sptech.hibernate.onetomany.demo.entity.Instructor;
import com.br.sptech.hibernate.onetomany.demo.entity.InstructorDetail;
import com.br.sptech.hibernate.onetomany.demo.entity.Review;

public class CreateReviewDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Course c1 = session.get(Course.class, 3);
			
			Review r1 = new Review("Tecnicas de programação em Java");
			
			c1.add(r1);
			
			session.save(r1);
			
			//or
			
			Course c2 = session.get(Course.class, 4);
			
			Review r2 = new Review("Tecnicas de programação em Java");
			Review r3 = new Review("Programação Java");
			Review r4 = new Review("Tecnicas em Java");
			
			c2.add(r2);
			c2.add(r3);
			c2.add(r4);
			
			session.save(c2);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
