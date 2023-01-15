package com.microservices.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productid")
	private int pi;

	@Column(name = "productname")
	private String productName;

	@Column(name = "productprice")
	private double productPrice;

	@Override
	public String toString() {
		return "Product [pi=" + pi + ", productName=" + productName + ", productPrice=" + productPrice + "]";
	}

	public Product() {
		super();
	}

	public Product(String productName, double productPrice) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public int getPi() {
		return pi;
	}

	public void setPi(int pi) {
		this.pi = pi;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

}
