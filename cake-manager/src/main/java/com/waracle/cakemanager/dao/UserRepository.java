package com.waracle.cakemanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.waracle.cakemanager.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
  User findByUserName(String userName);
  
}
