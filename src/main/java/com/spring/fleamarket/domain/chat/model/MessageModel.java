package com.spring.fleamarket.domain.chat.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
public class MessageModel {

	private String message;
	@Setter
	private String fromLogin;
	@Setter
	private String to;
	
	@Builder
	public MessageModel() {
		
	}

	
}
