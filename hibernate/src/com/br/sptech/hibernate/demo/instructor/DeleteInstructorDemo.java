package com.br.sptech.hibernate.demo.instructor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.br.sptech.hibernate.demo.entity.Instructor;
import com.br.sptech.hibernate.demo.entity.InstructorDetail;
import com.br.sptech.hibernate.demo.entity.Student;

public class DeleteInstructorDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			Instructor i = session.get(Instructor.class, 2);
			
			InstructorDetail id = session.get(InstructorDetail.class, 4);
			
//			session.delete(i);
//			session.createQuery("delete from Student where id=6").executeUpdate();
			
			id.getInstructor().setInstructorDetail(null);
			session.delete(id);
			
			session.getTransaction().commit();
		
		} finally {
			session.close();
		}
	}

}
