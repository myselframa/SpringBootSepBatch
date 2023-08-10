package com.fmc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fmc.demo.clinet.CardsFeignClient;
import com.fmc.demo.clinet.LoansFeignClient;
import com.fmc.demo.config.AccountServiceConfig;
import com.fmc.demo.model.Accounts;
import com.fmc.demo.model.Cards;
import com.fmc.demo.model.Customer;
import com.fmc.demo.model.CustomerDetails;
import com.fmc.demo.model.Loans;
import com.fmc.demo.model.Properties;
import com.fmc.demo.repository.AccountsRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class AccountsController {
	@Autowired
	private AccountsRepo accountsRepo;
	
	@Autowired
	private AccountServiceConfig accountServiceConfig;
	@Autowired
	private CardsFeignClient cardsFeignClient;
	@Autowired
	private LoansFeignClient loansFeignClient;
	
	@PostMapping("/myAccount")
	public Accounts getAccountDetails(@RequestBody Customer customer) {
		
		Accounts accounts=accountsRepo.findByCustomerId(customer.getCustomerId());
		if(accounts!=null) {
			return accounts;
		}else {
			return null;
		}
	}
	
	@GetMapping("/account/properties")
	public String getProperties() throws JsonProcessingException {
		ObjectWriter ow=new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties =new Properties(accountServiceConfig.getMsg(),accountServiceConfig.getBuildVersion(),accountServiceConfig.getMailDetails(),accountServiceConfig.getActiveBranches());
		String jsonStr=ow.writeValueAsString(properties);
		return jsonStr;
		
	}
	
	@PostMapping("/myCustomerDetails")
	@CircuitBreaker(name="detailsForCustomerSupportApp",fallbackMethod = "myCustomerDetailsFallBack")
	@Retry(name="retryForCustomerDetails",fallbackMethod = "myCustomerDetailsFallBack")
	public CustomerDetails myCustomerDetails(@RequestBody Customer customer) {
		Accounts accounts=accountsRepo.findByCustomerId(customer.getCustomerId());
		List<Loans> loansDetails = loansFeignClient.getLoansDetails(customer);
		List<Cards> loansDetails2 = cardsFeignClient.getCardsDetails(customer);
		
		CustomerDetails customerDetails = new CustomerDetails(); 
		customerDetails.setAccounts(accounts);
		customerDetails.setCards(loansDetails2);
		customerDetails.setLoans(loansDetails);
		
		return customerDetails;
	}
	
	private String myCustomerDetailsFallBack(Throwable t) {
		
		
		return "Hi";
	}
	
	@GetMapping("/sayHello")
	@RateLimiter(name="sayHello",fallbackMethod = "sayHelloFallabck")
	public String sayHello() {
		return "Hello";
	}
	
	private String sayHelloFallabck(Throwable t) {
		return "Hi welcome to FMC Bank";
		
	}
	
}
