package com.fmc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class BalanceController {

	@GetMapping("/balance")
	public String getMessage(){
		return "I am in balance controller";
	}
}
