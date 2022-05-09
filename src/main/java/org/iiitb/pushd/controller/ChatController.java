package org.iiitb.pushd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.iiitb.pushd.models.Chat;
import org.iiitb.pushd.services.ChatService;

@CrossOrigin
@RestController
@RequestMapping("chat")
public class ChatController {

	@Autowired
	private ChatService chatService;

	@GetMapping("get/{receiverId}")
	public List<Chat> getChats(@PathVariable String receiverId) {

		return this.chatService.getChats(receiverId);
	}

	@PostMapping("save")
	public Chat addChat(@RequestBody Chat chat) {

		return this.chatService.addChat(chat);
	}
}
