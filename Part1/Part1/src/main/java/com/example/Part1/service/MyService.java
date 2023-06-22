package com.example.Part1.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class MyService implements CommandLineRunner,Ordered{

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("I am in runner");
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 55;
	}

}
