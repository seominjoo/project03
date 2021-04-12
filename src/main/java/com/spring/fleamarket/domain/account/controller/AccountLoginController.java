package com.spring.fleamarket.domain.account.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.fleamarket.domain.model.Account;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping(value = "/account")
public class AccountLoginController {
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public String login(@Valid Account account, BindingResult bs) {
		log.info("account=" + account);
		if (bs.hasErrors()) {
			log.error(bs.getAllErrors());
			return "redirect:/account/login";
		}
		
		return "redirect:/";
	}
	
}
