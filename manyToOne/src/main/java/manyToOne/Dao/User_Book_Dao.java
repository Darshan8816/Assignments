package manyToOne.Dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import manyToOne.Dto.Books;
import manyToOne.Dto.User;

public class User_Book_Dao {

	static EntityManager manager = Persistence.createEntityManagerFactory("manyToOne").createEntityManager();
	static EntityTransaction t = manager.getTransaction();
	static Scanner sc = new Scanner(System.in);

	public void saveUser() {
		User User = saveU();
		manager.persist(User);
		t.begin();
		t.commit();
		System.out.println("User saved by id : " + User.getId());
	}

	private User saveU() {
		System.out.println("enter the name, email, phone_no, password");
		User ps = new User();
		ps.setName(sc.next());
		ps.setEmail(sc.next());
		ps.setPhone(sc.next());
		ps.setPassword(sc.next());
		return ps;
	}

	public void updateUser() {
		System.out.println("enter the User_id to update : ");
		int id = sc.nextInt();
		User ps = manager.find(User.class, id);
		if (ps != null) {
			System.out.println("Enter the name, email, phone, password");
			ps.setName(sc.next());
			ps.setEmail(sc.next());
			ps.setPhone(sc.next());
			ps.setPassword(sc.next());
			manager.merge(ps);
			t.begin();
			t.commit();
			System.out.println("User updated with the id : " + ps.getId() + " successfully...!!!");
			return;
		}
		System.err.println("enter the valid User Id...!!!");
	}

	public void deleteUser() {
		System.out.println("enter the User_id to delete : ");
		int id = sc.nextInt();
		User ps = manager.find(User.class, id);
		if (ps != null) {
			System.out.println("User with id : " + ps.getId() + " is deleted successfully...!!!");
			manager.remove(ps);
			t.begin();
			t.commit();
			return;
		}
		System.err.println("Invalid User id , please enter the valid User id");
	}

	public void findById() {
		System.out.println("Enter the User id you want to fetch the details...");
		int id = sc.nextInt();
		User ps = manager.find(User.class, id);
		if (ps != null) {
			System.out.println("\n");
			System.out.println("User id : " + ps.getId());
			System.out.println("User name : " + ps.getName());
			System.out.println("User email : " + ps.getEmail());
			System.out.println("User phone number : " + ps.getPhone());
			System.out.println("User password : " + ps.getPassword());
			System.out.println("\n\n");
			return;
		}
		System.err.println("Invalid User id , Please enter the valid id...!!!");
	}

	public void saveBooks() {
		System.out.println("Please enter the User Id ");
		int id = sc.nextInt();
		User p = manager.find(User.class, id);
		if (p != null) {
			Books bk = saveB();
			p.getBook().add(bk);
			bk.setUser(p);
			manager.persist(bk);
			t.begin();
			t.commit();
			System.out.println("Book is saved successfully...!!!");
		}

	}

	private Books saveB() {
		System.out.println("Enter the Book name , date , time , price ");
		Books bks = new Books();
		bks.setBook_name(sc.next());
		bks.setDate(sc.next());
		bks.setTime(sc.next());
		bks.setPrice(sc.nextInt());
		return bks;
	}

	public void updateBook() {
		System.out.println("Enter the Books_id to update... ");
		int id = sc.nextInt();
		Books bk = manager.find(Books.class, id);
		if (bk != null) {
			System.out.println("Enter the Books name , date , time , price... ");
			bk.setBook_name(sc.next());
			bk.setDate(sc.next());
			bk.setTime(sc.next());
			bk.setPrice(sc.nextInt());
			manager.merge(bk);
			t.begin();
			t.commit();
			System.out.println("Books updated with id :" + bk.getId() + " successfully...!!!");
			return;
		}
		System.err.println("Invalid Books id , please enter the valid Books id...!!!");
	}

	public void findBooksById() {
		System.out.println("Enter the Books id you want to fetch the details...");
		int id = sc.nextInt();
		Books ps = manager.find(Books.class, id);
		if (ps != null) {
			System.out.println("\n");
			System.out.println("Book name : " + ps.getBook_name());
			System.out.println("Date : " + ps.getDate());
			System.out.println("Time : " + ps.getTime());
			System.out.println("Price : " + ps.getPrice());
			System.out.println("User id : " + ps.getUser());
			System.out.println("\n\n");
			return;
		}
		System.err.println("Invalid Books id , Please enter the valid id...!!!");
	}

	public void deleteBooksById() {
		System.out.println("enter the Books_id to delete : ");
		int id = sc.nextInt();
		Books ps = manager.find(Books.class, id);
		if (ps != null) {
			System.out.println("Books with id : " + ps.getId() + " is deleted successfully...!!!");
			manager.remove(ps);
			t.begin();
			t.commit();
			return;
		}
		System.err.println("Invalid Books id , please enter the valid Books id...!!!");
	}

	public void find_Books_By_User_Id() {
		System.out.println("enter the User id ");
		int id = sc.nextInt();
		Query q = manager.createQuery("select b from Books b where b.user.id=?1");
		q.setParameter(1, id);
		List<Books> bk = q.getResultList();
		if (bk.size() > 0) {
			for (Books e : bk) {
				System.out.println("\n");
				System.out.println("Book name : " + e.getBook_name());
				System.out.println("Date : " + e.getDate());
				System.out.println("Time : " + e.getTime());
				System.out.println("Price : " + e.getPrice());
				System.out.println("\n");
			}
		} else {
			System.out.println("No books present in User id " + id);
		}
	}

}
