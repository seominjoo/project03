package com.spring.fleamarket.domain.account.service;

import javax.validation.Valid;

import com.spring.fleamarket.domain.account.dto.AccountImageRequest;
import com.spring.fleamarket.domain.model.AccountImage;

public interface AccountEditService {
	
	public void insertAccountImageByAccountId(@Valid AccountImageRequest request, AccountImage accountImage);
	
	public void updateAccountImageByAccountId(@Valid AccountImageRequest request, AccountImage accountImage);
	
	public void deleteAccountImageByAccountId(AccountImage accountImage);
	
}
