package com.spring.fleamarket.domain.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

	@GetMapping("/account/edit")
	public void getAccountEditPage() {}
	
}
