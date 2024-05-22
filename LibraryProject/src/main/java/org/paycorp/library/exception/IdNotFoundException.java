package org.paycorp.library.exception;

public class IdNotFoundException extends RuntimeException {

	@Override
	public String getMessage() {
		return "Invalid Id , please enter the valid Id...!!!";
	}
}
