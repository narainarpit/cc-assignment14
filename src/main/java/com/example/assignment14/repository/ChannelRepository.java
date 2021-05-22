package com.example.assignment14.repository;

import com.example.assignment14.dto.Channel;
import com.example.assignment14.dto.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ChannelRepository {

	List<Channel> channels = new ArrayList<>();

	public List<Channel> getAllChannels() {
		if (channels.isEmpty()){
			Channel channel = new Channel();
			channel.setName("General");
			channel.setId(1L);
			channels.add(channel);
		}
		return channels;
	}

	public List<Message> getMessages(Channel channel) {
		return channel.getMessages();
	}
}
