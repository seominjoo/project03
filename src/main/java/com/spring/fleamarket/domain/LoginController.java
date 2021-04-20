package com.spring.fleamarket.domain;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public void getLoginPage(Principal principal, Model model) {
		if (principal != null) {
			model.addAttribute("username", principal.getName());			
		}
	}
	
}
