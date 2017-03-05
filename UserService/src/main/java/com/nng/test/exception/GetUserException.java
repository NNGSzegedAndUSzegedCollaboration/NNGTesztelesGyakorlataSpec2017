package com.nng.test.exception;

public class GetUserException extends Exception {
	
	private static final long serialVersionUID = -1456935969041705713L;

	public GetUserException() {
		super();
	}

	public GetUserException(String message) {
		super(message);
	}

	public GetUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public GetUserException(Throwable cause) {
		super(cause);
	}
}
