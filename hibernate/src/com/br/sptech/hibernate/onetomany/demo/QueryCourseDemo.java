package com.br.sptech.hibernate.onetomany.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.br.sptech.hibernate.onetomany.demo.entity.Course;
import com.br.sptech.hibernate.onetomany.demo.entity.Instructor;
import com.br.sptech.hibernate.onetomany.demo.entity.InstructorDetail;
import com.br.sptech.hibernate.onetomany.demo.entity.Review;

public class QueryCourseDemo {

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
			
			Course c = session.get(Course.class, 1);
			
			System.out.println(c.getReviews());
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
