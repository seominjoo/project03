package com.spring.fleamarket.domain.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class AccountController {

	@GetMapping("/account/edit")
	public void getAccountEditPage() {}
	
	@PostMapping("/account/image")
	public String uploadAccountImage(MultipartFile file) {
		log.info("file=" + file);
		log.info(file.getOriginalFilename());
		
		return "redirect:/account/edit";
	}
	
}
