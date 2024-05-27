package com.example.assignment.exception;

public class IdNotFound extends RuntimeException {

	@Override
	public String getMessage() {
		return "Invalid id, please enter valid id";
	}
}
