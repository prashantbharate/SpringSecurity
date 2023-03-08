package com.example.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query("select s from Customer s where s.email=?1")
	public Optional<Customer> FindByEmail(String email);
}
