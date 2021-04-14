package com.spring.fleamarket.resource;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.spring.fleamarket.model.User;
import com.spring.fleamarket.model.UserResponse;

@Controller
public class UserController {
	
	@MessageMapping("/user")
	@SendTo("/topic/user")
	public UserResponse getUser(User user) throws Exception{
		
		return new UserResponse("Hi" + user.getName());
	}
	
	
}
