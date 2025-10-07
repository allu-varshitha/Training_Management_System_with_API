package com.rgt.employee.dto;

public class User {

	private int uid;
	private String uname;
	private String urole;
	
	public User(String uname, String urole) {
		this.uname = uname;
		this.urole = urole;
	}
	public User() {	
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUrole() {
		return urole;
	}

	public void setUrole(String urole) {
		this.urole = urole;
	}
	
	
	
}
