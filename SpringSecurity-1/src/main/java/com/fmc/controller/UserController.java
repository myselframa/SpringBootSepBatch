package com.fmc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fmc.model.User;
import com.fmc.repo.UserRepository;
import com.fmc.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userservice;
	
	@PostMapping("/save")
	public String saveUser(@RequestBody User user) {
		Integer id=userservice.saveUser(user);
		String message = "User is created with id "+id;
		return message;
	}
	
}
