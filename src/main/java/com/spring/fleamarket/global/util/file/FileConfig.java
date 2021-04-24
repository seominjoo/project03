package com.spring.fleamarket.global.util.file;

import java.io.File;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class FileConfig {
	
	private String root = "C:\\MyFleaMarket";
	private String accountFileUploadPath = "\\account";
	
	private final int MAX_UPLOAD_SIZE = 10 * 1024 * 1024; // 10MB
	
	@Bean
	public MultipartResolver filterMultipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		
		multipartResolver.setMaxUploadSize(MAX_UPLOAD_SIZE);
		
		return multipartResolver;
	}
	
	@Bean(name = "accountFileUploadPath")
	public String accountFileUploadPath() {
		return root + File.separator + accountFileUploadPath;
	}
	
}
