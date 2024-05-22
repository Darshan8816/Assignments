package org.paycorp.library.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.paycorp.library.dao.BooksDao;
import org.paycorp.library.dao.CustomerDao;
import org.paycorp.library.dto.Books;
import org.paycorp.library.dto.Customer;
import org.paycorp.library.dto.ResponseStructure;
import org.paycorp.library.exception.IdNotFound;
import org.paycorp.library.exception.IdNotFoundException;
import org.paycorp.library.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	private BooksDao dao;

	@Autowired
	private CustomerDao Cdao;

	static private LocalDateTime dt;

	public ResponseEntity<ResponseStructure<Books>> saveBooks(Books b) {
		ResponseStructure<Books> res = new ResponseStructure<>();
		res.setData(dao.saveBook(b));
		res.setMessage("Book saved successfully...!!!");
		res.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Books>>(res, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Books>> updateBooks(Books b) {
		ResponseStructure<Books> res = new ResponseStructure<>();
		Books db = dao.findByBookId(b.getBook_id());
		if (db != null) {
			Books bk = db;
			bk.setBook_name(b.getBook_name());
			bk.setAuthor_name(b.getAuthor_name());
			bk.setCatagory(b.getCatagory());
			res.setData(dao.saveBook(bk));
			res.setMessage("Book updated with the Book_id :" + b.getBook_id());
			res.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Books>>(res, HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Books>> findBooksById(int id) {
		ResponseStructure<Books> res = new ResponseStructure<>();
		Books db = dao.findByBookId(id);
		if (db != null) {
			res.setData(db);
			res.setMessage("Book found successfully with Book_id :" + id);
			res.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Books>>(res, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<Books>>> findAllBooks() {
		ResponseStructure<List<Books>> res = new ResponseStructure<>();
		List<Books> db = dao.findAll();
		if (db.size() > 0) {
			res.setData(db);
			res.setMessage("All Books found successfully...!!!");
			res.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Books>>>(res, HttpStatus.OK);
		}
		res.setData(null);
		res.setMessage("No Books is found...!!!");
		res.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Books>>>(res, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<Boolean>> deleteBooksById(int id) {
		ResponseStructure<Boolean> res = new ResponseStructure<>();
		if (dao.deleteBookById(id)) {
			res.setData(true);
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("Book deleted successfully with the id : " + id);
			return new ResponseEntity<ResponseStructure<Boolean>>(res, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Books>> borrowBook(String phone, String password, int id, int book_id) {
		ResponseStructure<Books> res = new ResponseStructure<>();
		Optional<Customer> db = Cdao.verifyByPhone(phone, password);
		if (db.isPresent()) {
			Customer cus = Cdao.findCustomerById(id);
			Books dbb = dao.findByBookId(book_id);
			if (cus != null && dbb != null) {
				cus.getBooks().add(dbb);
				dbb.setCustomer(cus);
				dbb.setBorrow_DateAndTime(dt.now().toString());
				dbb.setReturn_DateAndTime(null);
				res.setData(dao.saveBook(dbb));
				res.setMessage("Book borrowed by customer id : " + cus.getId());
				res.setStatusCode(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<Books>>(res, HttpStatus.OK);
			}
			throw new IdNotFound();
		}
		throw new InvalidCredentialsException();
	}

	public ResponseEntity<ResponseStructure<Books>> returnBook(String phone, String password, int id, int book_id) {
		ResponseStructure<Books> res = new ResponseStructure<>();
		Optional<Customer> db = Cdao.verifyByPhone(phone, password);
		if (db.isPresent()) {
			Customer cus = Cdao.findCustomerById(id);
			Books dbb = dao.findByBookId(book_id);
			if (cus != null && dbb != null) {
				res.setData(dbb);
				dbb.setCustomer(null);
				cus.getBooks().remove(dbb);
				dbb.setReturn_DateAndTime(dt.now().toString());
				dao.saveBook(dbb);
				res.setMessage("Book returned by customer id : " + cus.getId());
				res.setStatusCode(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<Books>>(res, HttpStatus.OK);
			}
			throw new IdNotFound();
		}
		throw new InvalidCredentialsException();
	}

	public ResponseEntity<ResponseStructure<List<Books>>> findBooksByCustomerId(int id) {
		ResponseStructure<List<Books>> res = new ResponseStructure<>();
		List<Books> db = dao.findBooksByCustomerId(id);
		if (db.size() > 0) {
			res.setData(db);
			res.setMessage("Above are the Books taked by Customer id : " + id);
			res.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Books>>>(res, HttpStatus.OK);
		}
		res.setData(null);
		res.setMessage("No Books is found in the customer id : " + id);
		res.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Books>>>(res, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Books>>> findByBook_name(String book_name) {
		ResponseStructure<List<Books>> res = new ResponseStructure<>();
		List<Books> db = dao.findByBook_name(book_name);
		if (db.size() > 0) {
			res.setData(db);
			res.setMessage("Above are the Books exsits in the name : " + book_name);
			res.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Books>>>(res, HttpStatus.OK);
		}
		res.setData(null);
		res.setMessage("No Books is found in this book name : " + book_name);
		res.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Books>>>(res, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Books>>> findByAuthorName(String author_name) {
		ResponseStructure<List<Books>> res = new ResponseStructure<>();
		List<Books> db = dao.findByAuthor_name(author_name);
		if (db.size() > 0) {
			res.setData(db);
			res.setMessage("Above are the Books in the author name of " + author_name);
			res.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Books>>>(res, HttpStatus.OK);
		}
		res.setData(null);
		res.setMessage("No Books is found in this author name " + author_name);
		res.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Books>>>(res, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Books>>> findByBookCatagory(String catagory) {
		ResponseStructure<List<Books>> res = new ResponseStructure<>();
		List<Books> db = dao.findByCatagory(catagory);
		if (db.size() > 0) {
			res.setData(db);
			res.setMessage("Above are the Books in the catagory : " + catagory);
			res.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Books>>>(res, HttpStatus.OK);
		}
		res.setData(null);
		res.setMessage("No Books is found in the catagory " + catagory);
		res.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Books>>>(res, HttpStatus.NOT_FOUND);
	}

}
