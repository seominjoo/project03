package com.spring.fleamarket.domain;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.fleamarket.domain.model.Account;
import com.spring.fleamarket.global.security.annotation.LoginedAccount;
import com.spring.fleamarket.global.security.model.LoginResponse;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class HomeController {
	
	/*
	 * 최초 페이지에 접속했을 때, CSRF 토큰을 발급한다.
	 */
	@GetMapping("/")
	public ResponseEntity<String> init(CsrfToken token) {
		log.info("token=" + token.getToken());
		return new ResponseEntity<>(token.getToken(), HttpStatus.OK);
	}
	
}
