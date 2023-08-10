package com.app;

public class Test {

	public static void main(String[] args) {
		PaymentGateway pay= new NetBanking();
		System.out.println("message: "+pay.debit(140) );
		System.out.println("message :"+pay.credit(140));
		PaymentGateway paym= new CashOnDelivery();
		
		System.out.println("message :"+paym.credit(140));
	}
}
