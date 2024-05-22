package org.paycorp.library.controller;

import java.util.List;

import org.paycorp.library.dto.Books;
import org.paycorp.library.dto.ResponseStructure;
import org.paycorp.library.service.BookService;
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
public class BooksContoller {

	@Autowired
	private BookService service;

	@PostMapping("/book")
	public ResponseEntity<ResponseStructure<Books>> saveBook(@RequestBody Books b) {
		return service.saveBooks(b);
	}

	@PutMapping("/book")
	public ResponseEntity<ResponseStructure<Books>> updateBook(@RequestBody Books b) {
		return service.updateBooks(b);
	}

	@GetMapping("/book/{id}")
	public ResponseEntity<ResponseStructure<Books>> findByBookId(@PathVariable int id) {
		return service.findBooksById(id);
	}

	@GetMapping("/book")
	public ResponseEntity<ResponseStructure<List<Books>>> findAllBooks() {
		return service.findAllBooks();
	}

	@DeleteMapping("/book/{id}")
	public ResponseEntity<ResponseStructure<Boolean>> deleteBookById(@PathVariable int id) {
		return service.deleteBooksById(id);
	}

	@PutMapping("/book/borrow")
	public ResponseEntity<ResponseStructure<Books>> bookBorrow(@RequestParam String phone,
			@RequestParam String password, @RequestParam int id, @RequestParam int book_id) {
		return service.borrowBook(phone, password, id, book_id);
	}

	@PutMapping("/book/return")
	public ResponseEntity<ResponseStructure<Books>> returnBook(@RequestParam String phone,
			@RequestParam String password, @RequestParam int id, @RequestParam int book_id) {
		return service.returnBook(phone, password, id, book_id);
	}

	@GetMapping("/book/id")
	public ResponseEntity<ResponseStructure<List<Books>>> findBooksByCustomerId(@RequestParam int id) {
		return service.findBooksByCustomerId(id);
	}

	@GetMapping("/book/book-name")
	public ResponseEntity<ResponseStructure<List<Books>>> findBooksByCustomerId(@RequestParam String book_name) {
		return service.findByBook_name(book_name);
	}

	@GetMapping("/book/author-name")
	public ResponseEntity<ResponseStructure<List<Books>>> findBooksByAuthorName(@RequestParam String author_name) {
		return service.findByAuthorName(author_name);
	}

	@GetMapping("/book/catagory")
	public ResponseEntity<ResponseStructure<List<Books>>> findBoosByCatagory(@RequestParam String catagory) {
		return service.findByBookCatagory(catagory);
	}
}
