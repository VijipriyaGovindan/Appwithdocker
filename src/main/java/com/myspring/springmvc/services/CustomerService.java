package com.myspring.springmvc.services;

import java.util.List;

import com.myspring.springmvc.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void deleteCustomer(int theId);

	public Customer getCustomer(int theId);
	
	public void saveCustomer(Customer customer
			);

}
