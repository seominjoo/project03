package com.spring.fleamarket.domain.account.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.fleamarket.domain.account.dto.AccountSession;
import com.spring.fleamarket.domain.account.service.AccountFindService;
import com.spring.fleamarket.domain.model.Account;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping(value = "/account")
public class AccountLoginController {
	
	@Autowired
	private AccountFindService accountFindService;
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public String login(@Valid Account input, BindingResult bs, HttpSession session) {
		log.info("input=" + input);
		
		if (bs.hasErrors()) {
			log.error(bs.getAllErrors());
			return "redirect:/account/login";
		}
		
		Account account = accountFindService.selectAccountByName(input.getName());
		if (account != null) {
			if (input.getPassword().equals(account.getPassword())) {
				log.info("Login Success - " + account);
				session.setAttribute("account", new AccountSession(account));
				
				return "redirect:/";
			} else {
				log.error("Login Fail - Password not matches");
			}
		} else {
			log.error("Login Fail - Account name not exists");
		}
		
		return "redirect:/account/login";	
	}
	
}
