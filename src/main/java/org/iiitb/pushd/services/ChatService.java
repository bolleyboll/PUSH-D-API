package org.iiitb.pushd.services;

import java.util.List;

import org.iiitb.pushd.models.Chat;

public interface ChatService {

	public List<Chat> getChats(String id);

	public Chat addChat(Chat chat);

}
