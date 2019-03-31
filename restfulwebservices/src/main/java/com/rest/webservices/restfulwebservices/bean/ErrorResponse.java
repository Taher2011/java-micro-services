package com.rest.webservices.restfulwebservices.bean;

import java.util.Date;

public class ErrorResponse {

	private int status;
	private String message;
	private long timestamp;

	public ErrorResponse() {
		super();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}
