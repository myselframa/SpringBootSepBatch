package com.app;

public class CashOnDelivery implements PaymentGateway{

	@Override
	public String debit(Integer amount) {
		// TODO Auto-generated method stub
		return "amount "+amount+" has been paid";
	}
	
	 String myBalance(Integer amount) {
		return "In your bank account "+amount+" has been credited";
	}

}
