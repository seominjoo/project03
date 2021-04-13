package com.spring.fleamarket.domain.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.apache.ibatis.type.Alias;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Alias("Account")
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
	private String image;
	
	@Builder
	public Account(String name, String password) {
		this.name = name;
		this.password = password;
	}
}
