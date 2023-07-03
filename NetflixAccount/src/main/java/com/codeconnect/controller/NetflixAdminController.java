package com.codeconnect.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.codeconnect.exception.UserNotFoundException;
import com.codeconnect.model.NetflixAdminUser;
import com.codeconnect.service.impl.NetflixAdminServiceImpl;

@RestController
public class NetflixAdminController {
	
	@Autowired
	private NetflixAdminServiceImpl netflixAdminService;


	@GetMapping("/users")
	public List<NetflixAdminUser> getallUsers() {
		
		return netflixAdminService.findAll();
	}
	
	@GetMapping("/user/{id}")
	public NetflixAdminUser findUser(@PathVariable Integer id) {
		
		NetflixAdminUser user = netflixAdminService.findUser(id);
		if(user == null) {
			throw new UserNotFoundException("id  :"+id);
		}
		return user;
	}
	
	@PostMapping("/new")
	public ResponseEntity createUser( @RequestBody NetflixAdminUser nau) {
		
		NetflixAdminUser nua= netflixAdminService.saveUser(nau);
		URI location=ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(nua.getUid()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable int id) {
		netflixAdminService.deleteById(id);
	}
	

}
