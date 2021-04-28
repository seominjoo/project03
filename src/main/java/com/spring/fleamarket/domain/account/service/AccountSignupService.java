package com.spring.fleamarket.domain.account.service;

import javax.validation.Valid;

import com.spring.fleamarket.domain.model.Account;
import com.spring.fleamarket.domain.model.User;

public interface AccountSignupService {

	public void createAccount(@Valid Account account, @Valid User user) throws Exception;
	
}
