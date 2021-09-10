package com.techment.exception;

public class InvalidUserExcpetion extends RuntimeException {
	String msg;

	public InvalidUserExcpetion(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
