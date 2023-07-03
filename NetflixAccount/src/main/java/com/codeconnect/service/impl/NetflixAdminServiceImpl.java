package com.codeconnect.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.codeconnect.model.NetflixAdminUser;
import com.codeconnect.service.NetflixAdminService;



@Service
public class NetflixAdminServiceImpl implements NetflixAdminService{

	private static List<NetflixAdminUser> netflixAdminUsers=new ArrayList();
	
	static {
		netflixAdminUsers.add(new NetflixAdminUser(1, "kesav", LocalDate.now().minusYears(3)));
		netflixAdminUsers.add(new NetflixAdminUser(2, "Venky", LocalDate.now().minusYears(2)));
		netflixAdminUsers.add(new NetflixAdminUser(3, "Ravi", LocalDate.now().minusYears(4)));
	}
	
	public static List<NetflixAdminUser> findAll(){
		return netflixAdminUsers;
	}
	public static NetflixAdminUser saveUser(NetflixAdminUser user){
		 netflixAdminUsers.add(user);
		 return user;
	}
	public NetflixAdminUser findUser(Integer id) {
		Predicate<? super NetflixAdminUser> predicate=netflixAdminUser->netflixAdminUser.getUid().equals(id);
		return netflixAdminUsers.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public void deleteById(int id) {
		Predicate<? super NetflixAdminUser> predicate=netflixAdminUser->netflixAdminUser.getUid().equals(id);
		netflixAdminUsers.removeIf(predicate);
		
	}
}
