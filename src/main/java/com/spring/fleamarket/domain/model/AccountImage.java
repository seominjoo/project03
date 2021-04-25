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

	public static final String DEFAULT_PATH = "noimage.png";
	
	private int accountId;
	@Setter
	private String path;
	
	@Builder
	public AccountImage(int accountId) {
		this.accountId = accountId;
		this.path = DEFAULT_PATH;
	}
	
	@Builder
	public AccountImage(int accountId, String path) {
		this.accountId = accountId;
		if (path != null) {
			this.path = path;
		} else {
			this.path = DEFAULT_PATH;
		}
	}
}
