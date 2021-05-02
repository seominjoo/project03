package com.spring.fleamarket.domain.chat.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import com.spring.fleamarket.domain.account.service.AccountFindService;
import com.spring.fleamarket.domain.chat.model.MessageModel;
import com.spring.fleamarket.domain.chat.service.MessageSaveService;


@RestController
public class MessageController {
	
	@Autowired
	MessageSaveService service;
	
	@Autowired
	AccountFindService serviceAF;

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	@MessageMapping("/chat/{receiverId}")
	public void sendMessage(@DestinationVariable String receiverId, MessageModel message, Principal pc) {
		
		System.out.println("handling send message: " + message);
		
		service.saveMessage(message);
					
		boolean isExists = serviceAF.selectAccountByName(message.getReceiverId()).getName().contains(message.getReceiverId());
		if(isExists) {
			simpMessagingTemplate.convertAndSend("/topic/messages/" + message.getReceiverId(), message);
		}
	}
	
	
}
