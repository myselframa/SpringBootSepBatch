package com.app;

public interface PaymentGateway {

	String debit(Integer amount);
	default String credit(Integer amount) {
		return "In your bank account "+amount+" has been credited";
	}
	static String myBalance(Integer amount) {
		return "In your bank account "+amount+" has been credited";
	}
}
