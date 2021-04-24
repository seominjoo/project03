package com.spring.fleamarket.domain.model;

import org.apache.ibatis.type.Alias;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Alias("AccountImage")
@Getter
@ToString
public class AccountImage {

	private int accountId;
	@Setter
	private String path;
	
	@Builder
	public AccountImage(int accountId) {
		this.accountId = accountId;
	}
	
}
