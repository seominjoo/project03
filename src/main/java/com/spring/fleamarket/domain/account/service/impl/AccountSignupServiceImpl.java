package com.spring.fleamarket.domain.account.service.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.spring.fleamarket.domain.account.mapper.AccountSignupMapper;
import com.spring.fleamarket.domain.account.service.AccountSignupService;
import com.spring.fleamarket.domain.model.Account;
import com.spring.fleamarket.domain.model.User;

@Service
@Validated
public class AccountSignupServiceImpl implements AccountSignupService {
	
	@Autowired
	AccountSignupMapper mapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Transactional
	@Override
	public void createAccount(@Valid Account account, @Valid User user) throws Exception {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		mapper.insertAccount(account);
		
		user.setAccountId(account.getId());
		mapper.insertUser(user);
	}

}

