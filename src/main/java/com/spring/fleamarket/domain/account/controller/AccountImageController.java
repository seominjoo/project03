package com.spring.fleamarket.domain.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.fleamarket.domain.account.service.AccountFindService;
import com.spring.fleamarket.domain.account.service.AccountImageService;
import com.spring.fleamarket.domain.model.AccountImage;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class AccountImageController {

	@Autowired
	private AccountImageService accountImageService;
	
	@Autowired
	private AccountFindService accountFindService;
	
	@GetMapping("/account/image/{accountId}")
	public ResponseEntity<byte[]> getAccoutImage(@PathVariable int accountId) {
		AccountImage accountImage = accountFindService.selectAccountImageByAccountId(accountId);
		if (accountImage == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		ResponseEntity<byte[]> result = null;
		HttpHeaders headers = null;
		byte[] image = null;
		try {
			headers = accountImageService.getHttpHeaders(accountImage.getPath());
			image = accountImageService.getImageBytes(accountImage.getPath());
			result = new ResponseEntity<byte[]>(image, headers, HttpStatus.OK);
		} catch (Exception e) {
			log.warn(e.getMessage());
			
			try {
				headers = accountImageService.getHttpHeaders(AccountImage.DEFAULT_PATH);
				image = accountImageService.getImageBytes(AccountImage.DEFAULT_PATH);
				result = new ResponseEntity<byte[]>(image, headers, HttpStatus.NOT_FOUND);
			} catch (Exception e1) {
				log.warn(e1.getMessage());
				result = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
			}
		}

		return result;
	}
	
	@PostMapping("/account/image")
	public String uploadAccountImage(MultipartFile file) {
		log.info("file=" + file);
		log.info(file.getOriginalFilename());
		
		return "redirect:/account/edit";
	}
	
}
