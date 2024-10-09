package com.danicascante.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danicascante.apirest.apirest.Repositories.ProductRepository;
import com.danicascante.apirest.apirest.Entities.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No Product with ID: " + id));
    }

    @PostMapping
    public Product createProduct (@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct (@PathVariable Long id, @RequestBody Product productDetails) {
        Product searchedProduct = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No Product with ID: " + id));

        searchedProduct.setName(productDetails.getName());
        searchedProduct.setPrice(productDetails.getPrice());

        return productRepository.save(searchedProduct);
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct (@PathVariable Long id) {
        Product searchedProduct = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No Product with ID: " + id));

        productRepository.delete(searchedProduct);

        return searchedProduct;
    }
    
}
