package com.example.ecom.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecom.Model.Product;
import com.example.ecom.Services.EcomService;

@RestController
@CrossOrigin("http://localhost:5173")
public class EcomController {
    
    @Autowired
    private EcomService service;

    @InitBinder
    public void InitBinder(WebDataBinder binder){
        binder.setDisallowedFields("image");
    }

    @PostMapping(value = "addProduct",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Product addProduct(
        @ModelAttribute Product product,
        @RequestParam("image") MultipartFile image
    ) throws IOException{
        product.setImage(image.getBytes());
        System.out.println(product);
        return service.addProduct(product);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        System.out.println("hello");
        return service.getAllProducts();
    }

    @PostMapping("search")
    public List<Product> search(@RequestParam String query){
        return service.productNameContains(query);
    }
}
