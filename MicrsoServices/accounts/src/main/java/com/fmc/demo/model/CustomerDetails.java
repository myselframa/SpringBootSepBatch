package com.fmc.demo.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter @Getter @ToString
public class CustomerDetails {

	private Accounts accounts;
	private List<Loans> loans;
	private List<Cards> cards;
}
