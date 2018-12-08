package com.hatim.oauth.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hatim.oauth.model.User;

@Service(value = "userService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Override
	public List<User> findAll() {
		return Arrays.asList(new User(1,"hatim","hatim",2,2) , new User(2,"kamal","kamal",2,2));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new org.springframework.security.core.userdetails.User("hatim", "hatim", Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
	}

}
