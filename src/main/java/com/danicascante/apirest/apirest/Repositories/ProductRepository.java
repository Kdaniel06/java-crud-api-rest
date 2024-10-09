package com.danicascante.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danicascante.apirest.apirest.Entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
