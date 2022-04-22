package org.iiitb.pushd.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.iiitb.pushd.models.Chat;
import org.iiitb.pushd.services.ChatService;

@RestController
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	
	
	@GetMapping("/home")
	public String home()
	{
		return "this is my home";
	}
	
	@GetMapping("/chatget/{receiverId}")
	public List<Chat> getChats(@PathVariable String receiverId)
	{
		
		return this.chatService.getChats(receiverId);
	}
	
	
	
	
	@PostMapping("/chatsave")
	public Chat addChats(@RequestBody Chat chat)
	{
		
		return this.chatService.addChats(chat);
	}
}
