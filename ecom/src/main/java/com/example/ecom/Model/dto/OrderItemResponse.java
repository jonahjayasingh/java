package com.example.ecom.Model.dto;


public record OrderItemResponse(
    String productName,
    int quantiy,
    int totalPrice
) {
    
}
