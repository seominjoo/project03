package com.spring.fleamarket.global.security.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.google.gson.Gson;
import com.spring.fleamarket.domain.model.Account;
import com.spring.fleamarket.global.security.model.LoginDetails;
import com.spring.fleamarket.global.security.model.LoginResponse;

import lombok.extern.log4j.Log4j;

@Log4j
public class RestAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	Gson gson = new Gson();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		log.info("LOGIN SUCCESS");
		
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication auth = context.getAuthentication();
		Account account = ((LoginDetails) auth.getPrincipal()).getAccount();
		
		LoginResponse userInfo = LoginResponse.builder()
										.id(account.getId())
										.username(account.getName())
										.build();
		
		response.setStatus(HttpStatus.OK.value());
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().println(gson.toJson(userInfo));
	}

}
