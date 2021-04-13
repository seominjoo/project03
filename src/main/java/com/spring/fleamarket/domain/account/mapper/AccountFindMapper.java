package com.spring.fleamarket.domain.account.mapper;

import com.spring.fleamarket.domain.model.Account;

public interface AccountFindMapper {
	
	public Account selectAccountByName(String name);
	
}
