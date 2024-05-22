package org.paycorp.library.repository;

import java.util.List;

import org.paycorp.library.dto.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Books, Integer> {

	@Query("select b from Books b where b.book_id=?1")
	public Books findByBookId(int id);

	@Query("select b from Books b where b.book_name=?1")
	public List<Books> findByBook_name(String name);

	@Query("select b from Books b where b.author_name=?1")
	public List<Books> findByBook_author(String author);

	@Query("select b from Books b where b.catagory=?1")
	public List<Books> findByBook_catagory(String catagory);

	@Query("select b from Books b where b.customer.id=?1")
	public List<Books> findBooksByCustomerId(int id);
}
