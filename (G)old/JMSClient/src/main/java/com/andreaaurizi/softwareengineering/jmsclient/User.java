package com.andreaaurizi.softwareengineering.jmsclient;

public class User {
	private static User instanza = new User();
	private String user = null;
	
	private User() {}
	
	public static final User getInstance() {
		return instanza;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
}
