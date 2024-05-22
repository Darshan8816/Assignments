package org.paycorp.library.exception;

public class InvalidCredentialsException extends RuntimeException {

	@Override
	public String getMessage() {
		return "Invalid Credentials , please enter the valid credentials...!!!";
	}
}