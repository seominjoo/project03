package com.spring.fleamarket.domain.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.apache.ibatis.type.Alias;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Alias("Account")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class Account {
	
	private int id;
	@NotEmpty
	private String name;
	@Setter
	@NotBlank
	private String password;
	private Date createdDate;
	
	@Builder
	public Account(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
}
