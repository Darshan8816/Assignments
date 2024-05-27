package com.example.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.assignment.dto.ResponseStructure;

public class ExceptionHandler extends ResponseEntityExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> INFException(IdNotFound e) {
		ResponseStructure<String> res = new ResponseStructure<>();
		res.setData(e.getMessage());
		res.setMsg("invalid id , please enter the valid id...!!!");
		return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.OK);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> ICException(InvalidCredentials e) {
		ResponseStructure<String> res = new ResponseStructure<>();
		res.setData(e.getMessage());
		res.setMsg("invalid credentials , please enter the valid phone number or password...!!!");
		return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.OK);
	}
}
