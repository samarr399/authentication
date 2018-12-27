package com.crud.example.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crud.example.entity.User;
import com.crud.example.repository.UserRepository;
@Service
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUsers = userRepository.findByName(username);
		if (!optionalUsers.isPresent()) {
			throw new UsernameNotFoundException("Username is not found");
		}
		return new CustomUserDetails(optionalUsers.get());
	}

}
