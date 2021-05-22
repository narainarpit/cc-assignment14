package com.example.assignment14.web;

import com.example.assignment14.dto.User;
import com.example.assignment14.repository.ChannelRepository;
import com.example.assignment14.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ChannelController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ChannelRepository channelRepository;

	@GetMapping("user/{userId}/channels")
	public String getChannel(ModelMap modelMap, @PathVariable String userId) {
		User user = userRepository.getUser((Long.valueOf(userId)));
		if (user == null) {
			return "redirect:/welcome";
		}
		modelMap.put("user", userRepository.getUser(Long.valueOf(userId)));
		modelMap.put("channels", channelRepository.getAllChannels());
		return "channels";
	}
}
