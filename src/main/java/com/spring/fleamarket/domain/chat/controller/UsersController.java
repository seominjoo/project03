package com.spring.fleamarket.domain.chat.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.spring.fleamarket.domain.chat.model.MessageModel;
import com.spring.fleamarket.domain.chat.service.MessageSaveService;

@RestController
@CrossOrigin
public class UsersController {
	
	@Autowired
	MessageSaveService service;
	
	@GetMapping("/recallChat/{userName}")
	public List<MessageModel> recall(@PathVariable String userName, MessageModel msgModel, Principal pc) {
		
		msgModel.setSenderId(pc.getName());
		
		msgModel.setReceiverId(userName);
			
		return service.recallChat(msgModel);
	}
	
	
}
