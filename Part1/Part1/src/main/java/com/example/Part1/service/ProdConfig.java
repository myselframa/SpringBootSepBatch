package com.example.Part1.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "mail")
@Component
public class ProdConfig implements CommandLineRunner{
	
	private String id;
	private String too;
	
	
	
	public ProdConfig() {
		super();
	}



	public ProdConfig(String id, String too) {
		super();
		this.id = id;
		this.too = too;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getToo() {
		return too;
	}



	public void setToo(String too) {
		this.too = too;
	}



	@Override
	public String toString() {
		return "ProdConfig [id=" + id + ", too=" + too + "]";
	}



	@Override 
	public void run(String... args) throws Exception {
		  System.out.println(this); //System.out.println(this.toString()); 
		  } 

}
