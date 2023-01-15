package com.microservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.models.Product;
import com.microservices.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;

	public List<Product> getAllProducts() {
		Iterable<Product> iterable = this.repository.findAll();
		List<Product> list = (List<Product>) iterable;
		return list;

	}

	public Product getProductById(int id) {
		return this.repository.findById(id).get();
	}

	public Product saveProduct(Product product) {
		return this.repository.save(product);
	}
}
