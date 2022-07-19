package com.waracle.cakemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.waracle.cakemanager.dao.UserRepository;
import com.waracle.cakemanager.entity.User;

@Service
public class CakeUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		
		if(user == null)
			throw new UsernameNotFoundException("User not found");
		
		return new CakeUserDetails(user);
	}

}
