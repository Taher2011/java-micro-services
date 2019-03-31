package com.rest.webservices.restfulwebservices.bean;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("DynamicBeanFilter")
public class DynamicBean {

	private String userName;
	private String dept;
	private String password;

	public DynamicBean(String userName, String dept, String password) {
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
