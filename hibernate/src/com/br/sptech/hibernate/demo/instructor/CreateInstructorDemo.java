package com.br.sptech.hibernate.demo.instructor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.br.sptech.hibernate.demo.entity.Instructor;
import com.br.sptech.hibernate.demo.entity.InstructorDetail;
import com.br.sptech.hibernate.demo.entity.Student;

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
			
			Instructor i = new Instructor(null, "qw", "sda", "asd", new InstructorDetail(null, "ASDAS", "sadasda"));
			
			session.save(i);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
