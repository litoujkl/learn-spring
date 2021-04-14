package com.shuangji.xml;

public class Room {

	private User user;

	// 1. setter注入
//	public void setUser(User user) {
//		this.user = user;
//	}

	// 2. 构造器注入
	public Room(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
}
