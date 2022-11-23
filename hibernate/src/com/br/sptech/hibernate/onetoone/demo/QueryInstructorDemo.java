package com.br.sptech.hibernate.onetoone.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.br.sptech.hibernate.onetoone.demo.entity.Instructor;
import com.br.sptech.hibernate.onetoone.demo.entity.InstructorDetail;

public class QueryInstructorDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Query<Instructor> query = session.createQuery("select i from Instructor i join fetch i.courses where i.id = :theInstructorId", Instructor.class);
			
			query.setParameter("theInstructorId", 5);
			
			Instructor i = query.getSingleResult();
			
			Instructor in = session.get(Instructor.class, 5);
			
			System.out.println(in);
			System.out.println(i);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
