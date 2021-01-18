package com.myspring.springmvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.springmvc.dao.CustomerDao;
import com.myspring.springmvc.entity.Customer;
@Service
public class CustomerSerivceImpl implements CustomerService 
{
	@Autowired
   private CustomerDao customerDao;

	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDao.getCustomers();
	}
	
	@Transactional
	public void deleteCustomer(int theId) {
		
		customerDao.deleteCustomer(theId);
	}
	
	@Transactional
	public Customer getCustomer(int theId) {
		Customer customer = customerDao.getCustomer(theId);
		return customer;
	}
		
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}
}

