package com.spring.fleamarket.domain.account.service.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.fleamarket.domain.account.mapper.AccountSignupMapper;
import com.spring.fleamarket.domain.account.service.AccountSignupService;
import com.spring.fleamarket.domain.model.Account;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class AccountSignupServiceImpl implements AccountSignupService {
	
	@Autowired
	AccountSignupMapper mapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public void createAccount(@Valid Account account) {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		mapper.createAccount(account);
	}

}

