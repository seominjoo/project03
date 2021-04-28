package com.spring.fleamarket.domain.account.mapper;

import java.util.List;

import com.spring.fleamarket.domain.model.Account;

public interface AccountFindMapper {
	
	public Account selectAccountByName(String name);
	
	public List<Account> selectAll();
	
}
