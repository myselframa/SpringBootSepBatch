package com.codeconnect;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.codeconnect.model.Calculator;

@Component
public class Implementation implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Calculator add = (a,b)-> a+b;
		Calculator sub = (a,b)-> a-b;
		
		System.out.println(add.caluclate(12,13));
		
	}

	

}
