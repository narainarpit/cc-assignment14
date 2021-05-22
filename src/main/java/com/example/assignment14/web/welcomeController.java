package com.example.assignment14.web;

import com.example.assignment14.dto.User;
import com.example.assignment14.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class welcomeController {

	@Autowired
	UserService userService;

	@GetMapping("/welcome")
	public String getMapping() {
		return "welcome";
	}

	@PostMapping("/welcome")
	@ResponseBody
	public User getSuccessfulLogin(@RequestBody User user) {
		User returnUser = null;
		if (userService.getUser(user.getId()) == null) {
			returnUser = userService.createUser(user.getUserName());
		} else {
			returnUser = user;
		}
		return returnUser;
	}

}
