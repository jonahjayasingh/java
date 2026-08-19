package com.example.ecom.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecom.Model.Product;

@Repository
public interface EcomRepository extends JpaRepository<Product, Integer>{
    
    List<Product> findByProductNameContainingIgnoreCase(String productName);
}
