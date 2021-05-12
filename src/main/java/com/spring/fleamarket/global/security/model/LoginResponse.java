package com.spring.fleamarket.global.security.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LoginResponse {
	
	private int id;
	private String username;
	
	@Builder
	public LoginResponse(int id, String username) {
		this.id = id;
		this.username = username;
	}
	
}
