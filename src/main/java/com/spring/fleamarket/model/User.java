package com.spring.fleamarket.model;

import lombok.Data;

@Data
public class User {

	private String name;
	
	public User() {
		
	}
	
	public User(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
