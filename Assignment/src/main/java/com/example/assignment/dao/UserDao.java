package com.example.assignment.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.assignment.dto.User;
import com.example.assignment.repository.UserRepo;

@Repository
public class UserDao {

	@Autowired
	private UserRepo repo;

	public User saveUser(User u) {
		return repo.save(u);
	}

	public Optional<User> verifyByPhone(long phone, String password) {
		return repo.verifyByPhone(phone, password);
	}

	public Optional<User> verifyById(int id, String password) {
		return repo.verifyById(id, password);
	}
	
	public Optional<User> findById(int id) {
		return repo.findById(id);
	}

	public boolean deleteUserById(int id) {
		Optional<User> u = findById(id);
		if (u.isPresent()) {
			repo.delete(u.get());
			return true;
		}
		return false;
	}
}
