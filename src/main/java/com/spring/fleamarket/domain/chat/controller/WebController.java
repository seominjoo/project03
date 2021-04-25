package com.spring.fleamarket.domain.chat.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.fleamarket.domain.model.Account;
import com.spring.fleamarket.global.security.annotation.LoginedAccount;

@Controller
public class WebController {

	@GetMapping("/chat")
	public String getPage(Principal principal, Model model, @LoginedAccount Account account ) {
		
		if(principal !=null) {
			model.addAttribute("userName", principal.getName());
			
			System.out.println(account);
		}
		
		return "index";
	}
	
}
