package com.hibernate.orm.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROD_INFO")
public class Product {
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
