package com.spring.fleamarket.global.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.fleamarket.domain.account.mapper.AccountFindMapper;
import com.spring.fleamarket.domain.model.Account;
import com.spring.fleamarket.global.security.model.LoginDetails;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class LoginServiceImpl implements UserDetailsService {

	@Autowired
	AccountFindMapper mapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = mapper.selectAccountByName(username);
		if (account == null) {
			throw new UsernameNotFoundException("Not Found - " + username);
		}
		
		return new LoginDetails(account);
	}
	
}
