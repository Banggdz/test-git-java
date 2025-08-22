package com.javaweb.customerexception;

public class FieldRequiredException extends RuntimeException{
	public FieldRequiredException(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	public FieldRequiredException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public FieldRequiredException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FieldRequiredException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}