package com.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.models.Product;
import com.microservices.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService pService;

	@GetMapping("/")
	private List<Product> getAllUsers() {
		return this.pService.getAllProducts();
	}

	@PostMapping("/	")
	public Product saveProduct(@RequestBody Product product) {
		return this.pService.saveProduct(product);
	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		return this.pService.getProductById(id);
	}
}
