package com.spring.fleamarket.domain.account.dto;

import com.spring.fleamarket.domain.model.Account;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AccountSession {

	private int id;
	private String name;
	private String image;

	public AccountSession(Account account) {
		this.id = account.getId();
		this.name = account.getName();
		this.image = account.getImage();
	}
}
