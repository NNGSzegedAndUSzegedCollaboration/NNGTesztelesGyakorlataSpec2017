package com.nng.test.exception;

public class WrongUserNameException extends Exception {

	private static final long serialVersionUID = -5911534627868062138L;

	public WrongUserNameException() {
		super();
	}

	public WrongUserNameException(String message) {
		super(message);
	}

	public WrongUserNameException(String message, Throwable cause) {
		super(message, cause);
	}

	public WrongUserNameException(Throwable cause) {
		super(cause);
	}

}
