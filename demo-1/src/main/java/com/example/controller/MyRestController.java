package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	
	@GetMapping("/")
	public String helloWorld() {
		return "Hello world";
	}
	@GetMapping("/sname")
	public String myName(@RequestParam("name") String myname) {
		return "Hello "+myname;
	}
	@GetMapping("/exper/{exp}")
	public String myExp(@PathVariable("exp") Integer exp) {
		return "Hello my experience is "+exp;
	}
	@GetMapping("/number")
	public String swap(@RequestHeader("a") Integer a) {
		return "Hello my number is "+a;
	}

}
