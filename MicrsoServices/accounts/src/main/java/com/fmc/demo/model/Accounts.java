package com.fmc.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
public class Accounts {

	@Column(name="costomer_id")
	private int customerId;
	@Id
	@Column(name="account_number")
	private long accountNumber;
	@Column(name="account_type")
	private String accountType;
	@Column(name="branch_address")
	private String branchAddress;
	@Column(name="create_dt")
	private LocalDate createDt;
	
}
