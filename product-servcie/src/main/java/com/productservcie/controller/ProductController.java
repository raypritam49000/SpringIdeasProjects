package com.productservcie.controller;

import com.productservcie.Model.Product;
import com.productservcie.servcices.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long pid){
        return this.productService.getProductById(pid);
    }

    @PostMapping("/")
    public Product saveProduct(@RequestBody Product product){
        return  this.productService.saveProduct(product);
    }
}
