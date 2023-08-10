package com.fmc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fmc.model.Cards;
import com.fmc.model.Customer;
import com.fmc.repo.CardsRepository;

@RestController
public class CardsController {

	@Autowired
	private CardsRepository cardsRepo;
	
	@PostMapping("/myCards")
	private List<Cards> getCardDetails(@RequestBody Customer customer){
		List<Cards> cards = cardsRepo.findByCustomerId(customer.getCustomerId());
		if(cards!=null) {
			return cards;
		}else {
			return null;
		}
	}
}
