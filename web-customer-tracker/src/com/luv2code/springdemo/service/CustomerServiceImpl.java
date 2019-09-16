package com.luv2code.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		 customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomers(int theId) {
		
		return customerDAO.getCustomers(theId);
	}

	@Override
	@Transactional
	public Customer deleteCustomers(int theId) {
		// TODO Auto-generated method stub
		customerDAO.deleteCustomer(theId);
		return null;
	}

}
