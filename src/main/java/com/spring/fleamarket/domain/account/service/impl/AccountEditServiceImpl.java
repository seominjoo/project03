package com.spring.fleamarket.domain.account.service.impl;

import java.io.File;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.spring.fleamarket.domain.account.dto.AccountImageRequest;
import com.spring.fleamarket.domain.account.mapper.AccountEditMapper;
import com.spring.fleamarket.domain.account.service.AccountEditService;
import com.spring.fleamarket.domain.model.AccountImage;
import com.spring.fleamarket.global.util.file.FileUtils;

import lombok.extern.log4j.Log4j;

@Log4j
@Validated
@Service
public class AccountEditServiceImpl implements AccountEditService {

	@Resource(name = "accountFileUploadPath")
	String uploadPath;
	
	@Autowired
	private AccountEditMapper mapper;
	
	@Override
	public void insertAccountImageByAccountId(@Valid AccountImageRequest request, AccountImage accountImage) {		
		String path = null;
		try {
			path = uploadCroppedImageFile(request);
			accountImage.setPath(path);
			
			mapper.insertAccountImageByAccountId(accountImage);
		} catch (Exception e) {
			log.info(e.getMessage());
			if (path != null) {
				FileUtils.deleteFile(uploadPath + File.separator + path);				
			}
		}
		
	}

	@Override
	public void updateAccountImageByAccountId(@Valid AccountImageRequest request, AccountImage accountImage) {
		String newPath = null;
		try {
			newPath = uploadCroppedImageFile(request);
			accountImage.setPath(newPath);
				
			mapper.updateAccountImageByAccountId(accountImage);
			FileUtils.deleteFile(uploadPath + File.separator + accountImage.getPath());
		} catch (Exception e) {
			log.info(e.getMessage());
			if (newPath != null) {
				FileUtils.deleteFile(uploadPath + File.separator + newPath);	
			}
		}
		
	}
	
	@Override
	public void deleteAccountImageByAccountId(AccountImage accountImage) {
		try {
			mapper.deleteAccountImageByAccountId(accountImage.getAccountId());
			FileUtils.deleteFile(uploadPath + File.separator + accountImage.getPath());
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}
	
	private String uploadCroppedImageFile(AccountImageRequest request) throws Exception {
		return FileUtils.uploadCroppedImageFile(request.getFile(), 
											    uploadPath, 
											    request.getX(), 
											    request.getY(), 
											    request.getWidth(), 
											    request.getHeight(),
											    request.getResize());
	}

}
