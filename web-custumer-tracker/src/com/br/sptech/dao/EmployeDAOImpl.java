package com.br.sptech.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.br.sptech.entity.Employe;


@Repository
public class EmployeDAOImpl implements EmployeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Employe> getEmployers() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Employe> theQuery = currentSession.createQuery("from Employe", Employe.class);
		
		List<Employe> customers = theQuery.getResultList();
		
		return customers;
	}

}
