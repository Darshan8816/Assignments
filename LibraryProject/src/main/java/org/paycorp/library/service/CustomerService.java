package org.paycorp.library.service;

import java.util.List;
import java.util.Optional;

import org.paycorp.library.dao.CustomerDao;
import org.paycorp.library.dto.Customer;
import org.paycorp.library.dto.ResponseStructure;
import org.paycorp.library.exception.IdNotFoundException;
import org.paycorp.library.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao dao;

	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer c) {
		ResponseStructure<Customer> res = new ResponseStructure<>();
		res.setData(dao.saveCustomer(c));
		res.setMessage("Customer saved successfully...!!!");
		res.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Customer>>(res, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(Customer c) {
		ResponseStructure<Customer> res = new ResponseStructure<>();
		Customer db = dao.findCustomerById(c.getId());
		if (db != null) {
			Customer cus = db;
			cus.setName(c.getName());
			cus.setEmail(c.getEmail());
			cus.setPhone(c.getPhone());
			cus.setPassword(c.getPassword());
			res.setData(dao.saveCustomer(cus));
			res.setMessage("Customer updated with the id :" + c.getId());
			res.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Customer>>(res, HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Customer>> findCustomerById(int id) {
		ResponseStructure<Customer> res = new ResponseStructure<>();
		Customer db = dao.findCustomerById(id);
		if (db != null) {
			res.setData(db);
			res.setMessage("Customer found successfully with id :" + id);
			res.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Customer>>(res, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<Customer>>> findAllCustomer() {
		ResponseStructure<List<Customer>> res = new ResponseStructure<>();
		List<Customer> db = dao.findAllCustomer();
		if (db.size() > 0) {
			res.setData(db);
			res.setMessage("All Customer found successfully...!!!");
			res.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Customer>>>(res, HttpStatus.OK);
		}
		res.setData(null);
		res.setMessage("No Customer is found...!!!");
		res.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Customer>>>(res, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<Boolean>> deleteCustomerById(int id) {
		ResponseStructure<Boolean> res = new ResponseStructure<>();
		if (dao.deleteCustomerById(id)) {
			res.setData(true);
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("Customer deleted successfully with the id : " + id);
			return new ResponseEntity<ResponseStructure<Boolean>>(res, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Customer>> verifyByPhone(String phone, String password) {
		ResponseStructure<Customer> res = new ResponseStructure<>();
		Optional<Customer> db = dao.verifyByPhone(phone, password);
		if (db.isPresent()) {
			res.setData(db.get());
			res.setMessage("Verification done successfully with phone and password...!!!");
			res.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Customer>>(res, HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}

	public ResponseEntity<ResponseStructure<Customer>> verifyByEmail(String email, String password) {
		ResponseStructure<Customer> res = new ResponseStructure<>();
		Optional<Customer> db = dao.verifyByEmail(email, password);
		if (db.isPresent()) {
			res.setData(db.get());
			res.setMessage("Verification done successfully with email and password...!!!");
			res.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Customer>>(res, HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}

}
