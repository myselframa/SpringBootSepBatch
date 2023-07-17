package com.fmc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {
	
	@GetMapping("/cards")
	public String getMessage(){
		
		return "I am in cards controller";
		
	}

}
