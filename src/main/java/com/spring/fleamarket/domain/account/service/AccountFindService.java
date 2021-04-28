package com.spring.fleamarket.domain.account.service;

import java.util.List;

import com.spring.fleamarket.domain.model.Account;
import com.spring.fleamarket.domain.model.AccountImage;

public interface AccountFindService {
	
	public AccountImage selectAccountImageByAccountId(int accountId);
	
	public List<Account> selectAll();
	
}
