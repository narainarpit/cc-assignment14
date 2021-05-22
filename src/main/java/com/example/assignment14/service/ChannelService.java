package com.example.assignment14.service;

import com.example.assignment14.dto.Channel;
import com.example.assignment14.dto.Message;
import com.example.assignment14.dto.User;
import com.example.assignment14.repository.ChannelRepository;
import com.example.assignment14.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {
	@Autowired
	ChannelRepository channelRepository;

	@Autowired
	UserRepository userRepository;

	public List<Channel> getAllChannels() {
		return channelRepository.getAllChannels();
	}

	public Channel getChannelById(Long channelId) {

		return channelRepository.getAllChannels()
				.stream()
				.filter(e -> e.getId().equals(channelId)).findAny().orElse(null);
	}

	public List<Message> setMessage(Long channelId, String messageText, Long userId) {
		Channel channel = getChannelById(channelId);
		User user = userRepository.getUser(userId);
		Message postedMessage = new Message();
		postedMessage.setMessage(messageText);
		postedMessage.setUser(user);
		List<Message> messages = channel.getMessages();
		messages.add(postedMessage);
		channel.setMessages(messages);
		return channel.getMessages();
	}
}
