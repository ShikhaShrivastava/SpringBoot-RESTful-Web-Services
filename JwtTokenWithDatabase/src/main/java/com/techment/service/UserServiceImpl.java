package com.techment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techment.dto.UserDto;
import com.techment.entity.User;
import com.techment.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDto login(String Username, String password) {
		System.out.println("username = "+Username);
		System.out.println("password = "+password);

		User user= userRepository.findByUsernameAndPassword(Username, password).get();
		System.out.println(user.toString());
		
		UserDto userDto = new UserDto(user.getUsername(), user.getPassword(),"mytoken1");
		return userDto;
	}

}
