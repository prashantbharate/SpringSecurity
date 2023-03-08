package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Customer;
import com.example.Repository.CustomerRepository;

@RestController
public class LoginCotroller {

	@Autowired
	private CustomerRepository cr;
	
	
	@GetMapping("/SignIn")
	public ResponseEntity<Customer> getLoggedInCustomerDetailsHandler(Authentication auth)
	{
		Customer c=cr.FindByEmail(auth.getName()).orElseThrow(()-> new BadCredentialsException("bad credentials"));
		return new ResponseEntity<Customer>(c,HttpStatus.ACCEPTED);
	}
	
}
