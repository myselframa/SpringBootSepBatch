package com.example.Part1.service;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(53)
public class TypeARunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("=-=-=-=-Hello CommandLineRunner=-=-=-=");
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		System.out.println(args[3]);
		System.out.println(Arrays.asList(args));
		System.out.println("=-=-=-=-End of CommandLineRunner-=-=-=");	
	}

}
