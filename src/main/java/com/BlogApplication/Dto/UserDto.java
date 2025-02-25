package com.BlogApplication.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {   // UserDto class hum data transfer karne ke liye use karenge
	
 
 
private int id;
 private String name;
 private String email;
 private String password;
 private String about;
 
}
