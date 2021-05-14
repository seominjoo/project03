package com.spring.fleamarket.domain.productinfo.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.fleamarket.domain.HomeController;
import com.spring.fleamarket.domain.account.service.AccountFindService;
import com.spring.fleamarket.domain.account.service.AccountImageService;
import com.spring.fleamarket.domain.chat.model.MessageModel;
import com.spring.fleamarket.domain.chat.service.MessageSaveService;
import com.spring.fleamarket.domain.model.Product;
import com.spring.fleamarket.domain.productinfo.service.ProductService;

import lombok.extern.log4j.Log4j;


@RestController
@Log4j
public class ProductController{
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/productinfo", produces = "application/json; charset=UTF-8")
	public void setproduct(Product product) throws Exception {
		System.out.println("컨트롤러 옴");
		System.out.println(product);
		
		  productService.insertProduct(product);
		 
	}
	
}
