package com.spring.fleamarket.domain.account.mapper;

import java.util.List;

import com.spring.fleamarket.domain.model.Account;
import com.spring.fleamarket.domain.model.AccountImage;

public interface AccountFindMapper {
	
	public Account selectAccountByName(String name);
	
	public AccountImage selectAccountImageByAccountId(int accountId);
	
	public List<Account> selectAll();
	
}
