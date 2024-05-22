package org.paycorp.library.exception;

public class IdNotFound extends RuntimeException{

	@Override
	public String getMessage() {
		return "Invalid id ,Please enter the existing member id and existing Book_Id to proceed...!!!";
	}
}
