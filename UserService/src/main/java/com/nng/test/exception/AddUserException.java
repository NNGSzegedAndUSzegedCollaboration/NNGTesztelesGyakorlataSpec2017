package com.nng.test.exception;

public class AddUserException extends Exception {
	private static final long serialVersionUID = -1456935457041705713L;

	public AddUserException() {
		super();
	}

	public AddUserException(String message) {
		super(message);
	}

	public AddUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public AddUserException(Throwable cause) {
		super(cause);
	}
}
