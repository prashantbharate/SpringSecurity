package com.example.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.Model.Customer;
import com.example.Repository.CustomerRepository;

public class CustomerUserDetailsService implements UserDetailsService{

	@Autowired
	private CustomerRepository cr;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method 
		Optional<Customer> c=cr.FindByEmail(username);
		
		if(c.isPresent())
		{
			Customer cst= c.get();
			
			List<GrantedAuthority> authority= new ArrayList<>();
			
			return new User(cst.getEmail(),cst.getPassword(),authority);
		}
		else
		{
			throw new BadCredentialsException("UserDetails Not Found With this Username"+username);
		}
	}

}
