package com.example.ecom.Model.dto;

import java.time.LocalDate;
import java.util.List;

public record OrderResponse (
    String orderId,
    String name,
    String email,
    String Status,
    LocalDate orderDate,
    List<OrderItemResponse> items
){
    
}   
