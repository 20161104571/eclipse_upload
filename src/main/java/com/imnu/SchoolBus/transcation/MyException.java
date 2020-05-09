package com.imnu.SchoolBus.transcation;

public class MyException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private static final long serialVersionId = 1L;
	
	public MyException(String message) {
		super(message);
		System.out.println(serialVersionId);
	}
}
