package com.BikkadIT.BlogApi.serviceI;

import java.util.List;

import com.BikkadIT.BlogApi.entity.User;
import com.BikkadIT.BlogApi.payload.UserDto;

public interface UserServiceI {
	
	UserDto createUser(UserDto userDto);
	UserDto updateUser(UserDto userDto, Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUser();
	void deleteUser(Integer userId);

}
