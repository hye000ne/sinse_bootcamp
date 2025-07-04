package com.sinse.memberapp.exception;

public class MemberNotFoundException extends RuntimeException{
	public MemberNotFoundException(String msg) {
		super(msg);
	}
	
	public MemberNotFoundException(Exception e) {
		super(e);
	}
	
	public MemberNotFoundException(String msg, Throwable e) {
		super(msg, e);
	}
}
