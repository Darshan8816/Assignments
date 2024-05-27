package com.example.assignment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.assignment.dto.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.phone=?1 and u.password=?2")
	public Optional<User> verifyByPhone(long phone, String password);

	@Query("select u from User u where u.id=?1 and u.password=?2")
	public Optional<User> verifyById(int id, String password);
	
}
