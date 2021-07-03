package com.rest.aurant;

public class ResponseClass {
	private int status;
	private String message;
	public ResponseClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseClass(int status, String message) {
		super();
		this.status = status;
		this.message = message;
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
	

}
