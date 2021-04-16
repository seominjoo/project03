package com.spring.fleamarket.domain.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.fleamarket.domain.account.mapper.AccountFindMapper;
import com.spring.fleamarket.domain.account.service.AccountFindService;
import com.spring.fleamarket.domain.model.Account;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class AccountFindServiceImpl implements AccountFindService {

	@Autowired
	private AccountFindMapper mapper;
	
	@Override
	public Account selectAccountByName(String name) {
		return mapper.selectAccountByName(name);
	}

}
