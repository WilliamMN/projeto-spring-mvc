package com.br.sptech.dao;

import java.util.List;

import com.br.sptech.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();
	
	public void save(Customer customer);

	public Customer getCustomerById(Integer customerId);

	public void deleteCustomer(Customer customer);
}
