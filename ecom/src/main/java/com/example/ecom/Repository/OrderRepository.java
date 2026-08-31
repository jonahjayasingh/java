package com.example.ecom.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecom.Model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    
}
