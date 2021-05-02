package com.spring.fleamarket.domain.chat.model;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Alias("MessageModel")
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MessageModel {

	private int messageNo;
	@Setter
	private String senderId;
	@Setter
	private String receiverId;
	private String content;
		
}
