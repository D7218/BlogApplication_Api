package com.BlogApplication.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BlogApplication.Dto.ApiResponse;
import com.BlogApplication.Dto.UserDto;
import com.BlogApplication.service.UserService;

@RestController
@RequestMapping("/Api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	//post - create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser (@RequestBody UserDto userDto){
		 UserDto createUserDto = this.userService.createUser(userDto);
		 
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
		
	}
	
	// put update the data
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer userId){
		 UserDto updateUser = this.userService.updateUser(userDto, userId);
		 
		return ResponseEntity.ok(updateUser);
	}
	
	// delete  - delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
		this.userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", true),HttpStatus.OK);
		
	}
	
	// Get - show user
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}

}
