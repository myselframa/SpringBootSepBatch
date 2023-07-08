package com.codeconnect.controller;

import java.awt.print.Book;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
public class NetflixAdminController {
	
	@Autowired
	private NetflixAdminServiceImpl netflixAdminService;


	@GetMapping("/users")
	public List<NetflixAdminUser> getallUsers() {
		
		return netflixAdminService.findAll();
	}
	
	@Operation(summary = "Get a user by its id")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the user", 
	    content = { @Content(mediaType = "application/json", 
	      schema = @Schema(implementation = NetflixAdminUser.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid id supplied", 
	    content = @Content), 
	  @ApiResponse(responseCode = "404", description = "User not found", 
	    content = @Content) })
	@GetMapping("/user/{id}")
	public NetflixAdminUser findUser(@PathVariable Integer id) {
		
		NetflixAdminUser user = netflixAdminService.findUser(id);
		if(user == null) {
			throw new UserNotFoundException("id  :"+id);
		}
		return user;
	}
	
	@PostMapping("/new")
	public ResponseEntity createUser(@Valid @RequestBody NetflixAdminUser nau) {
		
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
