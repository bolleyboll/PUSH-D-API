package org.iiitb.pushd.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.iiitb.pushd.repositories.ChatRepository;
import org.iiitb.pushd.services.ChatService;
import org.iiitb.pushd.models.Chat;

@Service
@Transactional
public class ChatServiceImpl implements ChatService {

	@Autowired
	private ChatRepository chatDao;

	@Override
	public List<Chat> getChats(String id) {
		return chatDao.findByReceiverId(id);
	}

	@Override
	public Chat addChat(Chat chat) {
		chatDao.save(chat);
		return chat;
	}

}
