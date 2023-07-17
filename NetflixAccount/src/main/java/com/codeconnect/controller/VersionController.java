package com.codeconnect.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeconnect.model.Person;
import com.codeconnect.model.PersonV2;

@RestController
public class VersionController {
	//URI versionion --- (Twitter)
	@GetMapping("/v1/person")
	public Person getNmae() {
		return new Person("Ram swami");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getNmaeVersion2() {
		return new PersonV2("Ram","swami");
	}
	
	// RequestParameter -- Amozon

	@GetMapping(path="/person",params = "version=1")
	public Person getNamebyParm() {
		return new Person("Ram swami");
	}
	
	@GetMapping(path="/person",params = "version=2")
	public PersonV2 getNmaeparam() {
		return new PersonV2("Ram","swami");
	}
	
	//Header versioning -- Microsoft
    @GetMapping(path="/person/header" , headers = "X-API-VERSION=1")
	public Person getNamebyheader() {
		return new Person("Ram swami");
	}
    @GetMapping(path="/person/header" , headers = "X-API-VERSION=2")
	public PersonV2 getNmaeHeader() {
		return new PersonV2("Ram","swami");
	}
	
    // Media type versioning - GitHub
    
    @GetMapping(path="/person/media" ,produces = "application/fmc.app-v1+json")
	public Person getNamebyMedia() {
		return new Person("Ram swami");
	}
    @GetMapping(path="/person/media" , produces = "application/fmc.app-v2+json")
	public PersonV2 getNmaeMedia() {
		return new PersonV2("Ram","swami");
	}
	
}
