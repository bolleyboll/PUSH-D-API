package org.iiitb.pushd.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.iiitb.pushd.repositories.ChatRepository;
import org.iiitb.pushd.services.ChatService;
import org.iiitb.pushd.models.Chat;



@Service
public class ChatServiceImpl implements ChatService{
	
	@Autowired
	private ChatRepository chatDao;
	
	@Override
	public List<Chat> getChats(String receiverId) {
		return chatDao.findByReceiverId(receiverId);
		
		//return chatDao.findById(courseId).get();
	
	}
	
	@Override
	public Chat addChats(Chat chat)
	{
		chatDao.save(chat);
		return chat;
		
	}
	
	
	
}
