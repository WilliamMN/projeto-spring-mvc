package com.br.sptech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.sptech.dao.EmployeDAO;
import com.br.sptech.entity.Employe;

@Service
public class EmployeServiceImpl implements EmployeService{

	@Autowired
	private EmployeDAO employeDAO;
	
	@Override
	@Transactional
	public List<Employe> getEmployers() {
		return employeDAO.getEmployers();
	}

}
