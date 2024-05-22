package org.paycorp.library.exception;

import org.paycorp.library.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> INFException(IdNotFoundException e) {
		ResponseStructure<String> res = new ResponseStructure<>();
		res.setData(e.getMessage());
		res.setMessage("Invalid id , please enter the valid id...!!!");
		res.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> ICException(InvalidCredentialsException e) {
		ResponseStructure<String> res = new ResponseStructure<>();
		res.setData(e.getMessage());
		res.setMessage("Invalid Credentials , please enter the valid Credentials...!!!");
		res.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> INF(IdNotFound e) {
		ResponseStructure<String> res = new ResponseStructure<>();
		res.setData(e.getMessage());
		res.setMessage("Invalid id , please enter the valid id...!!!");
		res.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.NOT_FOUND);
	}
}