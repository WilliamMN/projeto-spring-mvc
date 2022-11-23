package com.br.sptech.hibernate.manytomany.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.br.sptech.hibernate.manytomany.demo.entity.Student;
import com.br.sptech.hibernate.manytomany.demo.entity.Course;
import com.br.sptech.hibernate.manytomany.demo.entity.Instructor;
import com.br.sptech.hibernate.manytomany.demo.entity.InstructorDetail;
import com.br.sptech.hibernate.manytomany.demo.entity.Review;

public class AddCoursesForStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Student st = session.get(Student.class, 10);
			
			System.out.println(st.getCourses());
			
			Course c1 = new Course("Linguagem de Programação 2 com alunos");
			
			c1.addStudent(st);
			
			Course c2 = new Course("Linguagem de Programação 3 com alunos");
			
			c2.addStudent(st);
			
			session.save(c1);
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
