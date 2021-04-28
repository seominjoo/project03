package com.spring.fleamarket.domain.account.mapper;

import java.sql.SQLException;

import com.spring.fleamarket.domain.model.AccountImage;

public interface AccountImageMapper {
	
	public void insertAccountImageByAccountId(AccountImage accountImage) throws SQLException;
	
	public void updateAccountImageByAccountId(AccountImage accountImage) throws SQLException;
	
	public void deleteAccountImageByAccountId(int accountId) throws SQLException;
	
}
