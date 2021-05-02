package com.spring.fleamarket.domain.chat.mapper;

import java.util.List;

import com.spring.fleamarket.domain.chat.model.MessageModel;

public interface MessageSaveMapper {

	public void saveMessage(MessageModel msgModel);
	
	public List<MessageModel> recallChat(MessageModel msgModel);

}
