package com.example.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment.dto.ResponseStructure;
import com.example.assignment.dto.User;
import com.example.assignment.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/user")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User u) {
		return service.saveUser(u);
	}

	@PutMapping("/user")
	public ResponseEntity<ResponseStructure<User>> updatetUser(@RequestBody User u) {
		return service.updateUser(u);
	}

	@GetMapping("/user/verify_ph")
	public ResponseEntity<ResponseStructure<User>> verifyByPhone(@RequestParam long phone,
			@RequestParam String password) {
		return service.verifyByPhone(phone, password);
	}

	@GetMapping("/user/verify_id")
	public ResponseEntity<ResponseStructure<User>> verifyById(@RequestParam int id, @RequestParam String password) {
		return service.verifyById(id, password);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<ResponseStructure<Boolean>> deleteUserById(@PathVariable int id) {
		return service.deleteUserById(id);
	}
}
