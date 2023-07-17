package com.fmc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	
	@GetMapping("/account")
	public String getMessage(){
		return "I am in accounts controller";
	}
}
