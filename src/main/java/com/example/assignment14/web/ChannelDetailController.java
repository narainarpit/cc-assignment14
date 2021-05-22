package com.example.assignment14.web;

import com.example.assignment14.dto.Channel;
import com.example.assignment14.dto.Message;
import com.example.assignment14.dto.User;
import com.example.assignment14.repository.UserRepository;
import com.example.assignment14.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ChannelDetailController {

	@Autowired
	ChannelService channelService;

	@Autowired
	UserRepository userRepository;

	@GetMapping("/user/{userId}/channels/detail/id/{channelId}")
	public String getChannelDetail(ModelMap modelMap, @PathVariable Long channelId, @PathVariable Long userId) {
		Channel channel = channelService.getChannelById(channelId);
		User user = userRepository.getUser(userId);
		if (user == null) {
			return "welcome";
		}
		modelMap.put("channel", channel);
		modelMap.put("user", user);
		return "channelDetail";
	}

	@PostMapping("/user/{userId}/channels/detail/id/{channelId}/message")
	@ResponseBody
	public List<Message> createMessage(@RequestBody Message message, @PathVariable Long channelId, @PathVariable Long userId) {
		message.setUser(userRepository.getUser(userId));
		channelService.getChannelById(channelId).getMessages().add(message);
		return channelService.getChannelById(channelId).getMessages();
	}

	@GetMapping("/user/{userId}/channels/detail/id/{channelId}/message")
	@ResponseBody
	public List<Message> getChannelMessages(@PathVariable Long channelId, @PathVariable String userId) {
		return channelService.getChannelById(channelId).getMessages();
	}
}
