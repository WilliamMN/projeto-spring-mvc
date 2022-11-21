package com.br.sptech.hibernate.demo.student;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.br.sptech.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();

			List<Student> listDoBanco = session.createQuery("from Student").getResultList();
			
			List<Student> listDoBancoComWhere = session.createQuery("from Student s where s.firstName = 'asd'").getResultList();
			
			displayStudents(listDoBanco);
			
			displayStudents(listDoBancoComWhere);
			
			System.out.println(listDoBancoComWhere);
			
			session.getTransaction().commit();
		
		} finally {
			session.close();
		}
	}

	private static void displayStudents(List<Student> listDoBanco) {
		for(Student tmp: listDoBanco) {
			System.out.println(tmp);
		}
	}

}
