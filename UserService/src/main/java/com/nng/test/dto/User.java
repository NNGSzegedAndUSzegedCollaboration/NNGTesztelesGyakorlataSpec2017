package com.nng.test.dto;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -5283829670456403120L;
	
	private Integer userId;
	private String username;
	
	public User() {
	}

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
