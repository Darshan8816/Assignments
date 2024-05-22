package org.paycorp.library.dao;

import java.util.List;
import java.util.Optional;

import org.paycorp.library.dto.Books;
import org.paycorp.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BooksDao {

	@Autowired
	public BookRepository repo;

	public Books saveBook(Books b) {
		return repo.save(b);
	}

	public Books findByBookId(int id) {
		return repo.findByBookId(id);
	}

	public Boolean deleteBookById(int id) {
		Optional<Books> b = repo.findById(id);
		if (b.isPresent()) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}

	public List<Books> findAll() {
		return repo.findAll();
	}

	public List<Books> findByBook_name(String name) {
		return repo.findByBook_name(name);
	}

	public List<Books> findByAuthor_name(String author_name) {
		return repo.findByBook_author(author_name);
	}

	public List<Books> findBooksByCustomerId(int id) {
		return repo.findBooksByCustomerId(id);
	}

	public List<Books> findByCatagory(String catagory) {
		return repo.findByBook_catagory(catagory);
	}

}
