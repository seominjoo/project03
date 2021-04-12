package com.spring.fleamarket.domain.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class Account {
	
	private int id;
	@NotBlank
	private String name;
	@NotBlank
	private String password;
	private Date createdDate;
	
	@Builder
	public Account(String name, String password) {
		this.name = name;
		this.password = password;
	}
}
