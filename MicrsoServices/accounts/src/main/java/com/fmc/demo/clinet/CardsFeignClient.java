package com.fmc.demo.clinet;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fmc.demo.model.Cards;
import com.fmc.demo.model.Customer;

@FeignClient("cards")
public interface CardsFeignClient {
	
	@RequestMapping(method = RequestMethod.POST, value = "myCards" , consumes="application/json")
	List<Cards> getCardsDetails(@RequestBody Customer customer);

}

