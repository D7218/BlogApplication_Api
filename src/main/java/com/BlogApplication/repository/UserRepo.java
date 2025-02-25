package com.BlogApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.BlogApplication.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
