package org.paycorp.library.dao;

import java.util.List;
import java.util.Optional;

import org.paycorp.library.dto.Customer;
import org.paycorp.library.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepository repo;

	public Customer saveCustomer(Customer c) {
		return repo.save(c);
	}

	public Customer findCustomerById(int id) {
		return repo.findByCustomerId(id);
	}

	public boolean deleteCustomerById(int id) {
		Optional<Customer> b = repo.findById(id);
		if (b.isPresent()) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}

	public List<Customer> findAllCustomer() {
		return repo.findAll();
	}

	public Optional<Customer> verifyByPhone(String phone, String password) {
		return repo.verifyByPhone(phone, password);
	}

	public Optional<Customer> verifyByEmail(String email, String password) {
		return repo.verifyByEmail(email, password);
	}
}
