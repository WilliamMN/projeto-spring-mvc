package com.br.sptech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.sptech.dao.CustomerDAO;
import com.br.sptech.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		customerDAO.save(customer);
	}

	@Override
	@Transactional
	public Customer getCustomerById(Integer customerId) {
		return customerDAO.getCustomerById(customerId);
	}

	@Override
	@Transactional
	public void deleteCustomer(Integer customerId) {
		Customer customer = customerDAO.getCustomerById(customerId);
		
		customerDAO.deleteCustomer(customer);		
	}
	
	

}
