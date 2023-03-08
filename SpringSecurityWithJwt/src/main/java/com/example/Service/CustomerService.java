package com.example.Service;

import java.util.List;

import com.example.Exception.CustomerException;
import com.example.Model.Customer;

public interface CustomerService {

	
	public Customer RegisterCustomer(Customer c)throws CustomerException;
	
	public Customer getCustomerDetailByEmail(String email)throws CustomerException;
	
	public List<Customer> getAllCustomer()throws CustomerException;

}
