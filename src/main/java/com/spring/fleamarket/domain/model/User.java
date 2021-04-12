package com.spring.fleamarket.domain.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class User {
	
	private int accountId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String image;

}
