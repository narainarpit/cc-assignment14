package com.example.assignment14.dto;

import java.util.ArrayList;
import java.util.List;

public class Channel {
	private String name;
	private Long id;
	private List<Message> messages = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

}
