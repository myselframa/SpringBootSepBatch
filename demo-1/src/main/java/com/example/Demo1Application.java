package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/demo-1");
		SpringApplication.run(Demo1Application.class, args);
	}

}
