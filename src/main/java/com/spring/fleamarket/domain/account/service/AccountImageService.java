package com.spring.fleamarket.domain.account.service;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;

import com.spring.fleamarket.domain.account.dto.AccountImageRequest;
import com.spring.fleamarket.domain.model.AccountImage;

public interface AccountImageService {
	
	public void insertAccountImageByAccountId(@Valid AccountImageRequest request, AccountImage accountImage) throws Exception;
	
	public void updateAccountImageByAccountId(@Valid AccountImageRequest request, AccountImage accountImage) throws Exception;
	
	public void deleteAccountImageByAccountId(AccountImage accountImage) throws Exception;
	
	public byte[] getImageBytes(String path) throws Exception;
	
	public HttpHeaders getHttpHeaders(String path) throws Exception;
	
}
