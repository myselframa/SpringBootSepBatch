package com.app;

public class NetBanking implements PaymentGateway{

	@Override
	public String debit(Integer amount) {
		// TODO Auto-generated method stub
		return "amount "+amount+" has been debited through netbanking" ;
	}
	@Override
	public String credit(Integer amount) {
		return "In your bank account "+(amount-10)+" has been credited";
	}

}
