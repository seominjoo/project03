package com.spring.fleamarket.domain.account.service;

import com.spring.fleamarket.domain.model.AccountImage;

public interface AccountFindService {
	
	public AccountImage selectAccountImageByAccountId(int accountId);
	
}
