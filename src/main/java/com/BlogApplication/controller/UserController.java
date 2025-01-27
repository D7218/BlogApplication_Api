package com.BlogApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BlogApplication.Dto.UserDto;
import com.BlogApplication.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	//post - create user
	@GetMapping("/")
	public ResponseEntity<UserDto> createUser (@RequestBody UserDto userDto){
		 UserDto createUserDto = this.userService.createUser(userDto);
		 
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
		
	}
	
	
	
	// put - update user
	
	// delete  - delete user
	
	// Get - show user
	

}
