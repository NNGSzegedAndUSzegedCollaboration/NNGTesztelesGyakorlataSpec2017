package com.nng.test.dto;

public class User {

	private Integer userId;
	private String username;

	public User(String name) {
		this.username = name;
	}

	public User(Integer userId, String username) {
		this.userId = userId;
		this.username = username;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
