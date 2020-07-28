package com.cen4010.geektext;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	public List<Users> getAllUsers() {
		List<Users> users = new ArrayList<>();
		usersRepository.findAll().forEach(users::add);
		return users;
	}
}
