package com.spring.fleamarket.domain.chat.service;

import java.util.List;

import com.spring.fleamarket.domain.chat.model.MessageModel;

public interface MessageSaveService {

	public void saveMessage(MessageModel msgModel);
	
	public List<MessageModel> recallChat(MessageModel msgModel);
		
}
