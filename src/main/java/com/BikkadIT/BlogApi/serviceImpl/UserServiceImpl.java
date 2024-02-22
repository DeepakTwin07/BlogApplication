package com.BikkadIT.BlogApi.serviceImpl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.BlogApi.entity.User;
import com.BikkadIT.BlogApi.exception.ResourseNotFoundException;
import com.BikkadIT.BlogApi.payload.UserDto;
import com.BikkadIT.BlogApi.repository.UserRepo;
import com.BikkadIT.BlogApi.serviceI.UserServiceI;

@Service
public class UserServiceImpl implements UserServiceI{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.UserToDto(savedUser);
	}


	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId)
		.orElseThrow(() -> new ResourseNotFoundException("User","id",userId));
		
		user.setName(user.getName());
		user.setEmail(user.getEmail());
		user.setPassword(user.getPassword());
		user.setAbout(user.getAbout());
		
		User saveUser = this.userRepo.save(user);
		UserDto userToDto = this.UserToDto(saveUser);
		return userToDto;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourseNotFoundException("User","id",userId));
				
		return this.UserToDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user -> this.UserToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourseNotFoundException("User", "Id",userId ));
		this.userRepo.delete(user);
		
	}

	public User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		/*
		 * user.setId(user.getId()); 
		 * user.setName(user.getName());
		 * user.setEmail(user.getEmail()); 
		 * user.setPaasword(user.getPaasword());
		 * user.setAbout(user.getAbout());
		 */
		return user;		
	}
	
	public UserDto UserToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		/*
		 * userDto.setId(userDto.getId()); 
		 * userDto.setName(userDto.getName());
		 * userDto.setEmail(userDto.getEmail());
		 * userDto.setPassword(userDto.getPassword());
		 * userDto.setAbout(userDto.getAbout());
		 */
		return userDto;
		
	}
}
