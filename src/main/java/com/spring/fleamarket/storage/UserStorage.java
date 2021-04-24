package com.spring.fleamarket.storage;

import java.util.HashSet;
import java.util.Set;

public class UserStorage {

	private static UserStorage instance;
	private static Set<String> users;
	
	private UserStorage() {
		users = new HashSet<>();
		
	}
	
	public static synchronized UserStorage getInstance() {
		if(instance==null) {
			instance = new UserStorage();
		}
		System.out.println(users);
		return instance;
	}
	
	public Set<String> getUsers(){
		return users;
	}
	
	public void setUser(String userName) throws Exception{
		if(users.contains(userName)) {
			throw new Exception("User already exists with userName: " + userName );
		}
		
		users.add(userName);
	}
	
	
}
