package com.codeconnect.model;

@FunctionalInterface
public interface Calculator {
	
	int caluclate(int a , int b);
	
	default void myname() {
		System.out.println("Ram");
	}
	
	static void myPlace(){
		System.out.println("hyd");}
}
