package com.rubicon.watermanagment.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.rubicon.watermanagment.shared.dto.UserDto;

@Service
public interface UserService extends UserDetailsService{

	UserDto CreateUser(UserDto userDto);
	UserDto getUser(String email);
	UserDto getUserByUserId(String userId);
	UserDto updateUser(String userId, UserDto user);
	void deleteUser(String userId);
	List<UserDto> getUsers(int page, int limit);
}
