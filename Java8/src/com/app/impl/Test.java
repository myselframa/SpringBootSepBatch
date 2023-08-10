package com.app.impl;

import java.util.function.Predicate;

import com.app.Caluclator;

public class Test {
	
	public static void main(String[] args) {
		
		Caluclator additon = (int a,int b) -> {return a+b;};
		
		Caluclator substraction = (int a,int b)->{return a-b;};
		
		System.out.println("this is output of addition "+additon.operation(2, 3));
		
		System.out.println("this is output of substraction "+substraction.operation(3, 3));
		
		Predicate isEven= (Integer Integer.parseInt(null))->{
			if(a%2==0) {
				return true;
			}else {
				return false;
			}
		};
		
	}

}
