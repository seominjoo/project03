package com.spring.fleamarket.domain.account.service;

import com.spring.fleamarket.domain.model.Account;

public interface AccountFindService {

	public Account selectAccountByName(String name);
	
}
