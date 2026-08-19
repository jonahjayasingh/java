package com.example.ecom.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecom.Model.Product;
import com.example.ecom.Repository.EcomRepository;

@Service
public class EcomService {

    @Autowired
    private EcomRepository repo;


    public Product addProduct(Product product){

        return repo.save(product);
    }

    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public List<Product> productNameContains(String productName){
        return repo.findByProductNameContainingIgnoreCase(productName);
    }

}
