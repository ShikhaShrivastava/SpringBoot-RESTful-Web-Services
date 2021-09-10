package com.techment.service;

import com.techment.dto.UserDto;

public interface IUserService {
	 UserDto login(String username, String password);
}
