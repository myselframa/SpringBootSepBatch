package com.fmc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
	
	@GetMapping("/loans")
	public String getMessage(){
		return "I am in Lonas controller";
	}

}
