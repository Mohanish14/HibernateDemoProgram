package com.hibernate.embedded_id;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.mapping.HibernateConfiguration;

public class EmbeddedIdDemo {
	public static void main(String[] args) {

		SessionFactory sessionfact = HibernateConfiguration.getSessionfactory(Book.class);

		CompositKey key1 = new CompositKey("AAAAA", "PPPP", "WWWWW");
		CompositKey key2 = new CompositKey("BBBBB", "QQQQ", "XXXXX");
		CompositKey key3 = new CompositKey("CCCCC", "RRRR", "YYYYY");
		CompositKey key4 = new CompositKey("DDDDD", "SSSS", "ZZZZZ");

		Book b1 = new Book(key1, 14255.89, 5);
		Book b2 = new Book(key2, 86425.94, 7); 
		Book b3 = new Book(key3, 55891.22, 8);
		Book b4 = new Book(key4, 25589.46, 2);

		Session session = sessionfact.openSession();
		Transaction tr = session.beginTransaction();
		session.save(b1);
		session.save(b2);
		session.save(b3);
		session.save(b4);
		session.flush();
		tr.commit();

	}

}

//composite -- key -- collection of multiple columns-- to make primary Key
//collection of --> name,author,publication

@Entity
@Table(name = "BOOK_MASTER")
class Book {
	@EmbeddedId
	private CompositKey key;
	private double bookPrice;
	private int bookQty;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(CompositKey key, double bookPrice, int bookQty) {
		super();
		this.key = key;
		this.bookPrice = bookPrice;
		this.bookQty = bookQty;
	}

	@Override
	public String toString() {
		return "Book [key=" + key + ", bookPrice=" + bookPrice + ", bookQty=" + bookQty + "]";
	}

	public CompositKey getKey() {
		return key;
	}

	public void setKey(CompositKey key) {
		this.key = key;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public int getBookQty() {
		return bookQty;
	}

	public void setBookQty(int bookQty) {
		this.bookQty = bookQty;
	}

}

@Embeddable
class CompositKey implements Serializable {

	private String bookName;
	private String bookAuther;
	private String bookPublication;

	public CompositKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompositKey(String bookName, String bookAuther, String bookPublication) {
		super();
		this.bookName = bookName;
		this.bookAuther = bookAuther;
		this.bookPublication = bookPublication;
	}

	@Override
	public String toString() {
		return "CompositKey [bookName=" + bookName + ", bookAuther=" + bookAuther + ", bookPublication="
				+ bookPublication + "]";
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuther() {
		return bookAuther;
	}

	public void setBookAuther(String bookAuther) {
		this.bookAuther = bookAuther;
	}

	public String getBookPublication() {
		return bookPublication;
	}

	public void setBookPublication(String bookPublication) {
		this.bookPublication = bookPublication;
	}

}
