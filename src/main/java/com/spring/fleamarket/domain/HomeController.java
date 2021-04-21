package com.spring.fleamarket.domain;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.fleamarket.domain.model.Account;
import com.spring.fleamarket.global.security.annotation.LoginedAccount;
import com.spring.fleamarket.global.security.model.LoginResponse;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class HomeController {
	
	@GetMapping("/")
	public String home(@AuthenticationPrincipal LoginResponse response) {
		log.info("response=" + response);

		return "home";
	}
	
}
