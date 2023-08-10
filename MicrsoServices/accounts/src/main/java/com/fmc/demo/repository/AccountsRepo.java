package com.fmc.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.fmc.demo.model.Accounts;

public interface AccountsRepo extends CrudRepository<Accounts,Long> {

	Accounts findByCustomerId(int customerId);
}
