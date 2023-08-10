package com.fmc.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fmc.model.Cards;

public interface CardsRepository extends CrudRepository<Cards, Long>{
	
	List<Cards> findByCustomerId(int customerId);

}
