package org.paycorp.library.controller;

import java.util.List;

import org.paycorp.library.dto.Customer;
import org.paycorp.library.dto.ResponseStructure;
import org.paycorp.library.service.CustomerService;
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

@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;

	@PostMapping("/member")
	public ResponseEntity<ResponseStructure<Customer>> saveBook(@RequestBody Customer b) {
		return service.saveCustomer(b);
	}

	@PutMapping("/member")
	public ResponseEntity<ResponseStructure<Customer>> updateBook(@RequestBody Customer b) {
		return service.updateCustomer(b);
	}

	@GetMapping("/member/{id}")
	public ResponseEntity<ResponseStructure<Customer>> findByBookId(@PathVariable int id) {
		return service.findCustomerById(id);
	}

	@GetMapping("/member")
	public ResponseEntity<ResponseStructure<List<Customer>>> findAllCustomer() {
		return service.findAllCustomer();
	}

	@DeleteMapping("/member/{id}")
	public ResponseEntity<ResponseStructure<Boolean>> deleteBookById(@PathVariable int id) {
		return service.deleteCustomerById(id);
	}

	@PutMapping("/member/verifyByPhone")
	public ResponseEntity<ResponseStructure<Customer>> verifyByPhone(@RequestParam String phone,
			@RequestParam String password) {
		return service.verifyByPhone(phone, password);
	}

	@PutMapping("/member/verifyByEmail")
	public ResponseEntity<ResponseStructure<Customer>> verifyByEmail(@RequestParam String email,
			@RequestParam String password) {
		return service.verifyByEmail(email, password);
	}

}
