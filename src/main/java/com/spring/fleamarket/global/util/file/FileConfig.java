package com.spring.fleamarket.global.util.file;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class FileConfig {
	
	private static final int MAX_UPLOAD_SIZE = 10240000; // 10MB
	
	@Bean
	public MultipartResolver filterMultipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		
		multipartResolver.setMaxUploadSize(MAX_UPLOAD_SIZE);
		
		return multipartResolver;
	}
	
}
