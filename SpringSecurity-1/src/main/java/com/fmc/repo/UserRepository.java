package com.fmc.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmc.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
		Optional<User> findByUserEmail(String userEmail);
}
