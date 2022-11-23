package com.br.sptech.hibernate.onetomany.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.br.sptech.hibernate.onetomany.demo.entity.Course;
import com.br.sptech.hibernate.onetomany.demo.entity.Instructor;
import com.br.sptech.hibernate.onetomany.demo.entity.InstructorDetail;
import com.br.sptech.hibernate.onetomany.demo.entity.Review;

public class QueryInstructorDemo {

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
			
			Query<Instructor> query = session.createQuery("select i from Instructor i join fetch i.courses where i.id = :theInstructorId", Instructor.class);
			
			query.setParameter("theInstructorId", 5);
			
			Instructor i = query.getSingleResult();
			
			Instructor in = session.get(Instructor.class, 5);
			
			System.out.println(in.getCourses());
			System.out.println(i.getCourses());
			
			session.getTransaction().commit();
			session.close();
			
			System.out.println(in.getCourses());
			System.out.println(i.getCourses());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
