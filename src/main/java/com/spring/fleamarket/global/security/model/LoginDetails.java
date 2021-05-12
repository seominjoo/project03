package com.spring.fleamarket.global.security.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.spring.fleamarket.domain.model.Account;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

public class LoginDetails extends User {

	private Account account;
	
	public LoginDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public LoginDetails(Account account) {
		super(account.getName(), 
			  account.getPassword(), 
			  List.of(new SimpleGrantedAuthority("ROLE_USER")));
		this.account = account;
	}
	
	public Account getAccount() {
		return account;
	}
}