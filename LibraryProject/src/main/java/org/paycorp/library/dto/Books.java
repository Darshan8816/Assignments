package org.paycorp.library.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int book_id;

	@Column(nullable = false)
	private String book_name, author_name, catagory;

	@Column(nullable = true)
	private String borrow_DateAndTime, return_DateAndTime;

	@ManyToOne
	private Customer customer;

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public String getBorrow_DateAndTime() {
		return borrow_DateAndTime;
	}

	public void setBorrow_DateAndTime(String borrow_DateAndTime) {
		this.borrow_DateAndTime = borrow_DateAndTime;
	}

	public String getReturn_DateAndTime() {
		return return_DateAndTime;
	}

	public void setReturn_DateAndTime(String return_DateAndTime) {
		this.return_DateAndTime = return_DateAndTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
