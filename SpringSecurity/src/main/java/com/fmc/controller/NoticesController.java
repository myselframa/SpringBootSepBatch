package com.fmc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {
	
	@GetMapping("/notice")
	public String getMessage(){
		return "I am in notice controller";
	}

}
