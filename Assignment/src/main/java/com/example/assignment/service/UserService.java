package com.example.assignment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.assignment.dao.UserDao;
import com.example.assignment.dto.ResponseStructure;
import com.example.assignment.dto.User;
import com.example.assignment.exception.IdNotFound;
import com.example.assignment.exception.InvalidCredentials;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User u) {
		ResponseStructure<User> res = new ResponseStructure<>();
		res.setData(dao.saveUser(u));
		res.setMsg("User saved successfully");
		res.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(res, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User u) {
		ResponseStructure<User> res = new ResponseStructure<>();
		Optional<User> us = dao.findById(u.getId());
		if (us.isPresent()) {
			User db = us.get();
			db.setName(u.getName());
			db.setPassword(u.getPassword());
			db.setPhone(u.getPhone());
			res.setData(dao.saveUser(db));
			res.setMsg("User updated successfully...!!!");
			res.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<User>>(res, HttpStatus.ACCEPTED);
		}
		throw new IdNotFound();
	}

	public ResponseEntity<ResponseStructure<User>> verifyByPhone(long phone, String password) {
		ResponseStructure<User> res = new ResponseStructure<>();
		Optional<User> us = dao.verifyByPhone(phone, password);
		if (us.isPresent()) {
			res.setData(us.get());
			res.setMsg("Verification successful through phone no and password...!!!");
			res.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(res, HttpStatus.OK);
		}
		throw new InvalidCredentials();
	}

	public ResponseEntity<ResponseStructure<User>> verifyById(int id, String password) {
		ResponseStructure<User> res = new ResponseStructure<>();
		Optional<User> us = dao.verifyById(id, password);
		if (us.isPresent()) {
			res.setData(us.get());
			res.setMsg("Verification successful through Id and password...!!!");
			res.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(res, HttpStatus.OK);
		}
		throw new IdNotFound();
	}

	public ResponseEntity<ResponseStructure<Boolean>> deleteUserById(int id) {
		ResponseStructure<Boolean> res = new ResponseStructure<>();
		boolean b = dao.deleteUserById(id);
		if (b) {
			res.setData(b);
			res.setMsg("User deleted successfully...!!!");
			res.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Boolean>>(res, HttpStatus.OK);
		}
		throw new IdNotFound();
	}

}
