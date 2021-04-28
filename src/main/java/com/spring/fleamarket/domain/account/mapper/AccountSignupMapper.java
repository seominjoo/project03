package com.spring.fleamarket.domain.account.mapper;

import com.spring.fleamarket.domain.model.Account;
import com.spring.fleamarket.domain.model.User;

public interface AccountSignupMapper {

	public void insertAccount(Account account);
	
	public void insertUser(User user);
	
}
