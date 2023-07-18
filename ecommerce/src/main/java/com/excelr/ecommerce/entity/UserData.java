package com.excelr.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserData {
	
	@Id
	private int userId;
	private String userName;
	private String location;
	private long phoneNumber;
	private String email;
	
	public UserData() {
	}

	public UserData(int userId, String userName, String location, long phoneNumber, String email) {
		this.userId = userId;
		this.userName = userName;
		this.location = location;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserData [userId=" + userId + ", userName=" + userName + ", location=" + location + ", phoneNumber="
				+ phoneNumber + ", email=" + email + "]";
	}
		
	
	
	
}
