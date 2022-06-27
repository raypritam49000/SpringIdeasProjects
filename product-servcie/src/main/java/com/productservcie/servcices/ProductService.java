package com.productservcie.servcices;

import com.productservcie.Model.Product;
import com.productservcie.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    public Product getProductById(Long pid){
        return this.productRepository.findById(pid).get();
    }

    public Product saveProduct(Product product){
      return  this.productRepository.save(product);
    }
}
