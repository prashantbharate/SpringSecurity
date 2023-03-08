package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exception.CustomerException;
import com.example.Model.Customer;
import com.example.Service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService cse;
	
	@Autowired
	private PasswordEncoder pe;
	
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer)throws CustomerException
	{
		customer.setPassword(pe.encode(customer.getPassword()));
		Customer cs1= cse.RegisterCustomer(customer);
		return new ResponseEntity<Customer>(cs1,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customers/{email}")
	public ResponseEntity<Customer> getByEmail(@PathVariable("email") String email)throws CustomerException
	{
		Customer cs2= cse.getCustomerDetailByEmail(email);
		return new ResponseEntity<Customer>(cs2,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customers/all")
	public ResponseEntity<List<Customer>> getAllCustomers()throws CustomerException
	{
		List<Customer> cs3= cse.getAllCustomer();
		return new ResponseEntity<List<Customer>>(cs3,HttpStatus.ACCEPTED);
	}

}
