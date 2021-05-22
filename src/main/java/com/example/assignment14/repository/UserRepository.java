package com.example.assignment14.repository;

import com.example.assignment14.dto.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
	private Long lastId = 1L;
	private List<User> users = new ArrayList<>();

	public User createUser(String userName){
		User user = new User(userName);
		users.add(user);
		user.setId(getNext());
		return user;
	}
	public User getUser(Long userId){
		return users.stream().filter(e -> e.getId().equals(userId)).findAny().orElse(null);
	}

	public synchronized Long getNext() {
		return lastId++;
	}

}
