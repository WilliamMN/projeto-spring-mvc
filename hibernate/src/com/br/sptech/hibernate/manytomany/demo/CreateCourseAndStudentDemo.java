package com.br.sptech.hibernate.manytomany.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.br.sptech.hibernate.manytomany.demo.entity.Student;
import com.br.sptech.hibernate.manytomany.demo.entity.Course;
import com.br.sptech.hibernate.manytomany.demo.entity.Instructor;
import com.br.sptech.hibernate.manytomany.demo.entity.InstructorDetail;
import com.br.sptech.hibernate.manytomany.demo.entity.Review;

public class CreateCourseAndStudentDemo {

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
			
			Course c1 = new Course("Linguagem de Programação com alunos");
			
			session.save(c1);
			
			Student st1 = new Student("Paulo", "Muniz", "paulo@email.com");
			Student st2 = new Student("Paulo2", "Muniz2", "paulo2@email.com");
			
			c1.addStudent(st1);
			c1.addStudent(st2);
			
			session.save(st1);
			session.save(st2);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
