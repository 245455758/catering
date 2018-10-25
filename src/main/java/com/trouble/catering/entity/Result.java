package com.trouble.catering.entity;

public class Result {
	
	private boolean res;
	private String message;
	public boolean isRes() {
		return res;
	}
	public void setRes(boolean res) {
		this.res = res;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Result(boolean res, String message) {
		super();
		this.res = res;
		this.message = message;
	}
	public Result() {
		super();
	}
	
	

}
