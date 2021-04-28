package com.spring.fleamarket.domain.chat.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import com.spring.fleamarket.domain.chat.model.MessageModel;
import com.spring.fleamarket.domain.chat.service.MessageSaveService;
import com.spring.fleamarket.domain.chat.storage.UserStorage;


@RestController
public class MessageController {
	
	@Autowired
	MessageSaveService service;

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	@MessageMapping("/chat/{to}")
	public void sendMessage(@DestinationVariable String to, MessageModel message, Principal pc) {
		System.out.println("handling send message: " + message + "to: " + to);
		
		//message.setFromLogin(pc.getName());
		
		message.setTo(to);
		
		service.saveMessage(message);
		
		boolean isExists = UserStorage.getInstance().getUsers().contains(to);
		if(isExists) {
			simpMessagingTemplate.convertAndSend("/topic/messages/" + to, message);
		}
	}
	
	
}
