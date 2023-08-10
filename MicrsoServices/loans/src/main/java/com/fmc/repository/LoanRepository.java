package com.fmc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fmc.model.Loans;

public interface LoanRepository extends CrudRepository<Loans, Integer>{
	
	List<Loans> findByCustomerId(int customerId);

}
