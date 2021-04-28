package com.spring.fleamarket.domain.account.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AccountImageRequest {

	@NotNull
	private MultipartFile file;
	
	@Min(value = 0)
	private int x;
	@Min(value = 0)
	private int y;
	private int width;
	private int height;
	
	private final int resize = 300;

	@Builder
	public AccountImageRequest(MultipartFile file, int x, int y, int width, int height) {
		this.file = file;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	
	
}
