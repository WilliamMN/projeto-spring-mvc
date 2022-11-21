package com.br.sptech.hibernate.demo.course;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.br.sptech.hibernate.demo.entity.Course;
import com.br.sptech.hibernate.demo.entity.Instructor;
import com.br.sptech.hibernate.demo.entity.InstructorDetail;

public class CreateCourseDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Instructor i = session.get(Instructor.class, 5);
			
			Course c1 = new Course(null, "bla bla", null);
			Course c2 = new Course(null, "bla2 bla2", null);
			
			i.add(c1);
			i.add(c2);
			
			session.save(c1);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
