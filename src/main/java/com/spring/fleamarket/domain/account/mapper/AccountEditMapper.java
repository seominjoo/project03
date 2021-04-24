package com.spring.fleamarket.domain.account.mapper;

import com.spring.fleamarket.domain.model.AccountImage;

public interface AccountEditMapper {
	
	public void insertAccountImageByAccountId(AccountImage accountImage) throws Exception;
	
	public void updateAccountImageByAccountId(AccountImage accountImage) throws Exception;
	
	public void deleteAccountImageByAccountId(int accountId) throws Exception;
	
}
