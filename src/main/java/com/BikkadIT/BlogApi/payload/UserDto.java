package com.BikkadIT.BlogApi.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	
	private int id;
	
	@NotEmpty
	@Size(min=4, message ="user name must of 4 char !!")
	private String name;
	
	@Email(message = "email address is not valid !!")
	private String email;
	
	@NotNull
	@Size(min=4, max=12, message = "Passward must be min 3 char max 12 char!!")
	private String password;
	
	@NotNull
	private String about;
}
