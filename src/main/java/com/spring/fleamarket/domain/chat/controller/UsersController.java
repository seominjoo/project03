package com.spring.fleamarket.domain.chat.controller;

import java.security.Principal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.fleamarket.domain.chat.model.MessageModel;
import com.spring.fleamarket.domain.chat.service.MessageSaveService;
import com.spring.fleamarket.domain.chat.storage.UserStorage;

@RestController
@CrossOrigin
public class UsersController {
	
	@Autowired
	MessageSaveService service;

	@GetMapping("/registration/{userName}")
	public ResponseEntity<Void> register(@PathVariable String userName){
		System.out.println("handling register user request" + userName);
		
		try {
			UserStorage.getInstance().setUser(userName);
			
		} catch (Exception e) {
			
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/fetchAllUsers")
	public Set<String> fetchAll(){
		return UserStorage.getInstance().getUsers();
	}
	
	@GetMapping("/recallChat/{userName}")
	public MessageModel recall(@PathVariable String userName, MessageModel msgModel, Principal pc) {
		
		msgModel.setFromLogin(pc.getName());
		
		msgModel.setTo(userName);
		
		System.out.println("check : " + userName);
		
		return msgModel;
	}
	
}
