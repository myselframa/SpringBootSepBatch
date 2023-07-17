package com.fmc.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fmc.model.User;
import com.fmc.repo.UserRepository;
import com.fmc.service.UserService;
@Service
public class UserServiceImpl implements UserService,UserDetailsService {

	@Autowired
	private UserRepository repo;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> findByUserEmail = repo.findByUserEmail(username);
		if(findByUserEmail.isEmpty()) {
			 throw new UsernameNotFoundException(username);
		}
		User user = findByUserEmail.get();
		List<SimpleGrantedAuthority> collect = user.getUserRole().stream().map(role -> new SimpleGrantedAuthority(role) )
												.collect(Collectors.toList());
		System.out.print(collect);
		return new org.springframework.security.core.userdetails.User(username,user.getUserPwd(),collect);
	}

	@Override
	public Integer saveUser(User user) {
		String encPwd = bCryptPasswordEncoder.encode(user.getUserPwd());
		user.setUserPwd(encPwd);
		return repo.save(user).getUserId();
	}

}
