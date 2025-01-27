package com.BlogApplication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import com.BlogApplication.Dto.UserDto;
import com.BlogApplication.exception.*;
import com.BlogApplication.entity.User;

import com.BlogApplication.repository.UserRepo;
import com.BlogApplication.service.UserService;

public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepo userRepo; 
	

	@Override
	public UserDto createUser(UserDto userDto) {
		//step 1 : convert userDto to User entity
		User user = this.dtoToUser(userDto);
		//step 2 : save the user entity to the database
		User saveUser = this.userRepo.save(user);
		
		//step 3 : convert the saved user entity back to userDto
		return this.userToDto(saveUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id",userId));
				
		user.setName(userDto.getName()); //update name
		user.setEmail(userDto.getEmail()); // update email
		user.setPassword(userDto.getPassword()); // update password
		user.setAbout(userDto.getAbout());// change about
		
		
		User  updatedUser = this.userRepo.save(user);
		UserDto userToDto1 = this.userToDto(updatedUser);
		 
		return userToDto1;
	}
	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("user", "Id", userId ));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user ->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}
	

	@Override
	public void deleteUser(Integer UserId) {
		User user = this.userRepo.findById(UserId).orElseThrow(()-> new ResourceNotFoundException("user", "Id", UserId));
		this.userRepo.delete(user);
	}
	 private User dtoToUser(UserDto userDto) {
		
		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		return user;
			 
	 }
	 
	 public UserDto userToDto(User user) {
		 UserDto.userDto = new UserDto();
		 user.setId(user.getId());
		 user.setName(user.getName());
		 user.setEmail(user.getEmail());
		 user.setPassword(user.getPassword());
		 user.setAbout(user.getAbout());
		return userToDto(user);
		 
	 }

}
