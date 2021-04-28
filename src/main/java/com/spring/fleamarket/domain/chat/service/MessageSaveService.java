package com.spring.fleamarket.domain.chat.service;

import com.spring.fleamarket.domain.chat.model.MessageModel;

public interface MessageSaveService {

	public void saveMessage(MessageModel msgModel);
	
	//public MessageModel recallMessage()
}
