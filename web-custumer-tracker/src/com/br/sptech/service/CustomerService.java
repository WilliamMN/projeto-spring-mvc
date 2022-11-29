package com.br.sptech.service;

import java.util.List;

import com.br.sptech.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	
	public void save(Customer customer);

	public Customer getCustomerById(Integer customerId);

	public void deleteCustomer(Integer customerId);
}
