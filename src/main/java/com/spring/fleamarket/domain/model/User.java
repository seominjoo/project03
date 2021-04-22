package com.spring.fleamarket.domain.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.apache.ibatis.type.Alias;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Alias("User")
@Getter
@ToString
public class User {
	
	@Setter
	private int accountId;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@Email
	@NotBlank
	private String email;
	private String phone;
	
	@Builder
	public User(String firstName, String lastName, String email, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}
	
	@Builder
	public User() {}
	
}
