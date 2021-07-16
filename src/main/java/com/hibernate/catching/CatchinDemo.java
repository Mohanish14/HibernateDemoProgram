package com.hibernate.catching;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.hibernate.mapping.HibernateConfiguration;


public class CatchinDemo {

	public static void main(String[] args) {

		Product prod = new Product(101, "Mobile", 5, 496584.96, "Flikart");

		SessionFactory sfactory = HibernateConfiguration.getSessionfactory(Product.class);
		
		Session session=sfactory.openSession();
		Transaction tr= session.beginTransaction();
		//session.save(prod);
		session.flush();
		tr.commit();
		
		Product pp=session.get(Product.class, 101);
		System.out.println(pp);
		
		Query hsqlQuery = session.createQuery("from Product where prodId=101");
		List<Product> prod1 = hsqlQuery.list();
		hsqlQuery.setCacheable(true);
		System.out.println("Using HQL" + prod1);
		
		session.close();
		
		Session session1=sfactory.openSession();

		Product pp1=session1.get(Product.class, 101);
		System.out.println(pp1);
		
		Query hsqlQuerys = session1.createQuery("from Product where prodId=101");
		List<Product> prod2 = hsqlQuerys.list();
		hsqlQuerys.setCacheable(true);

		System.out.println("Using HQL" + prod2);
	}

}

@Entity
@Table(name = "PROD_INFO")
@Cache(usage =CacheConcurrencyStrategy.READ_WRITE)
class Product {
	@Id
	private int prodId;
	private String prodName;
	private int prodQty;
	private double prodPrice;
	private String prodVendor;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int prodId, String prodName, int prodQty, double prodPrice, String prodVendor) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodQty = prodQty;
		this.prodPrice = prodPrice;
		this.prodVendor = prodVendor;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", prodQty=" + prodQty + ", prodPrice="
				+ prodPrice + ", prodVendor=" + prodVendor + "]";
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getProdQty() {
		return prodQty;
	}

	public void setProdQty(int prodQty) {
		this.prodQty = prodQty;
	}

	public double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getProdVendor() {
		return prodVendor;
	}

	public void setProdVendor(String prodVendor) {
		this.prodVendor = prodVendor;
	}

}
