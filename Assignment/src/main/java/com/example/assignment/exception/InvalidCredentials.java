package com.example.assignment.exception;

public class InvalidCredentials extends RuntimeException {

	@Override
	public String getMessage() {
		return "Invalid phone number or password , please enter the valid credentials...!!!";
	}
}
