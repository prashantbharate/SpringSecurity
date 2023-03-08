package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.CustomerException;
import com.example.Model.Customer;
import com.example.Repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository cr; 
	
	
	@Override
	public Customer RegisterCustomer(Customer c) throws CustomerException {
		// TODO Auto-generated method stub
		
		 Customer cs= cr.save(c);;
		 return cs;
	}

	@Override
	public Customer getCustomerDetailByEmail(String email) throws CustomerException {
		// TODO Auto-generated method stub
		Optional<Customer> cs= cr.FindByEmail(email);
		if(cs.isPresent())
		{
			Customer cst=cs.get(); 
			return cst;
		}
		else
		{
			throw new CustomerException("No Record FOund With that Email Id");
		}
	}

	@Override
	public List<Customer> getAllCustomer() throws CustomerException {
		// TODO Auto-generated method stub
		List<Customer> cs= cr.findAll();
		
		if(cs.isEmpty())
		{
			throw new CustomerException("No Record Found");
		}
		return cs;
	}

}
