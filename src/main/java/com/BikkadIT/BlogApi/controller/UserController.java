package com.BikkadIT.BlogApi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.BlogApi.payload.ApiResponse;
import com.BikkadIT.BlogApi.payload.UserDto;
import com.BikkadIT.BlogApi.serviceI.UserServiceI;


@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserServiceI userServiceI;

	//POST - CREATE USER
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto createUserDto = this.userServiceI.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
		
	}
	
	
	//PUT - UPDATE USER
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> upadateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uId){
		UserDto updateUser = this.userServiceI.updateUser(userDto, uId);
		return ResponseEntity.ok(updateUser);
		
	}
	//DELETE - DELETE USER
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uId){
		this.userServiceI.deleteUser(uId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User delete Succesfully", true), HttpStatus.OK);
		
	}
	//GET - GET USER
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser(){
		return ResponseEntity.ok(this.userServiceI.getAllUser());
		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable("userId") Integer UserId){
		return ResponseEntity.ok(this.userServiceI.getUserById(UserId));
		
	}
}
