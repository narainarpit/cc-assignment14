package com.example.assignment14.service;

import com.example.assignment14.dto.User;
import com.example.assignment14.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User createUser(String username) {
		return userRepository.createUser(username);
	}

	public User getUser(Long userId) {
		return userRepository.getUser(userId);
	}
}
