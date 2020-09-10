package com.websales.model;

import java.io.Serializable;
import java.util.Locale;

/**
 * The persistent class for the app_user database table.
 * 
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String userId;

	private Locale locale;

	private String userName;
	
	private String name;

	private String role;
	public User() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Locale getLocale() {
		return this.locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}