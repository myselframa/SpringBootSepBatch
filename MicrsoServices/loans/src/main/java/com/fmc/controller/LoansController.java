package com.fmc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fmc.model.Customer;
import com.fmc.model.Loans;
import com.fmc.repository.LoanRepository;

@RestController
public class LoansController {
	@Autowired
	private LoanRepository loanRepository;
	
	@PostMapping("/myLoans")
	private List<Loans> getLoanDetails(@RequestBody Customer customer){
		List<Loans> loans = loanRepository.findByCustomerId(customer.getCustomerId());
		
		if(loans!=null) {
			return loans;
		}else {
			return null;
		}
	}

}
