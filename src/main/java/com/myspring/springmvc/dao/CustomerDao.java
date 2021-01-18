package com.myspring.springmvc.dao;

import java.util.List;

import com.myspring.springmvc.entity.Customer;

public interface CustomerDao {
	
	public List<Customer> getCustomers();

	void deleteCustomer(int theId);

	void saveCustomer(Customer thecCustomer);

	Customer getCustomer(int theId);
	

}
