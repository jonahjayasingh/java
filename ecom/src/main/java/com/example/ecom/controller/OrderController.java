package com.example.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecom.Model.Order;
import com.example.ecom.Model.dto.OrderRequest;
import com.example.ecom.Model.dto.OrderResponse;
import com.example.ecom.Services.OrderService;

@RestController
@CrossOrigin("http://localhost:5173")
public class OrderController {

    @Autowired
    private OrderService service;


    @PostMapping("Order")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orders){

        OrderResponse orderResponse = service.placeOrder(orders);
        if(orderResponse != null){
            return ResponseEntity.ok(orderResponse);

        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("Order")
    public ResponseEntity<List<OrderResponse>> getAllOrders(){
        List<OrderResponse> responses = service.getAllOrders();
        if (responses.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(responses);
    }
    
}
