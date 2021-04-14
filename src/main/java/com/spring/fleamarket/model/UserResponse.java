package com.spring.fleamarket.model;

import lombok.Data;

@Data
public class UserResponse {

	String content;
	

	public UserResponse() {
		
	}
	
	public String getContent() {
		return content;
	}
	
	public UserResponse(String content) {
		this.content = content;
	}
}
