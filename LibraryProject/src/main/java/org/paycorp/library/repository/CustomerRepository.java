package org.paycorp.library.repository;

import java.util.Optional;

import org.paycorp.library.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("select c from Customer c where c.phone=?1 and c.password=?2")
	public Optional<Customer> verifyByPhone(String phone, String password);

	@Query("select c from Customer c where c.email=?1 and c.password=?2")
	public Optional<Customer> verifyByEmail(String email, String password);
	
	@Query("select c from Customer c where c.id=?1")
	public Customer findByCustomerId(int id);

}
