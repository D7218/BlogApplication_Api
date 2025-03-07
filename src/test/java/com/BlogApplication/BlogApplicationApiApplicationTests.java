package com.BlogApplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.BlogApplication.repository.UserRepo;

@SpringBootTest
class BlogApplicationApiApplicationTests {
	
	@Autowired
    private UserRepo userRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void repoTest() {
		String className = this.userRepo.getClass().getName();
		String packname = this.userRepo.getClass().getPackageName();
		System.out.println(className);
		System.out.println(packname);
	}

}
