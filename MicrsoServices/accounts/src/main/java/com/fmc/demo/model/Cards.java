package com.fmc.demo.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class Cards {
	
	
	private int cardId;
	private int customerId;
	private String cardType;
	private int totalLimit;
	private int amountUsed;
	private int availableAmount;
	private Date createDt;
	
	

}