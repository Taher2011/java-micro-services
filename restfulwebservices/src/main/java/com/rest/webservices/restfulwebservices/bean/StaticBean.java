package com.rest.webservices.restfulwebservices.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "userName" })
public class StaticBean {

	private String userName;
	private String dept;

	@JsonIgnore
	private String password;

	public StaticBean(String userName, String dept, String password) {
		super();
		this.userName = userName;
		this.dept = dept;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
