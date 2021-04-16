package com.spring.fleamarket.resource;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import com.spring.fleamarket.model.Greeting;
import com.spring.fleamarket.model.HelloMessage;

@Controller
public class UserController {
		
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		
		Thread.sleep(100); // delay
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
		
	}
	
	
}
