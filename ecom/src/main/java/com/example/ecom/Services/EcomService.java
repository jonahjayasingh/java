package com.example.ecom.Services;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
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

    public Optional<Product> productById(Integer id){
        return repo.findById(id);
    }

    public Product updateProduct(Product product){
        return repo.save(product);
    }

    public void deleteProduct(Integer id) {
        repo.deleteById(id);
    }

}
