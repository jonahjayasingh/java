package com.example.ecom.Services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecom.Model.Order;
import com.example.ecom.Model.OrderItem;
import com.example.ecom.Model.Product;
import com.example.ecom.Model.dto.OrderItemRequest;
import com.example.ecom.Model.dto.OrderItemResponse;
import com.example.ecom.Model.dto.OrderRequest;
import com.example.ecom.Model.dto.OrderResponse;
import com.example.ecom.Repository.EcomRepository;
import com.example.ecom.Repository.OrderItemRepository;
import com.example.ecom.Repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private EcomRepository productEcomRepository;

    public void createOrder(List<Order> order){

        
    }

    public OrderResponse placeOrder(OrderRequest request) {
        Order order = new Order();
        order.setName(request.customerName());
        order.setEmail(request.email());
        order.setStatus("Placed");
        order.setOrderdate(LocalDate.now());
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemRequest itemreq : request.items()){
            Product product = productEcomRepository.findById(itemreq.productId()).orElseThrow(() -> new RuntimeException("Prodct not found")) ;
            product.setStockCount(product.getStockCount()-itemreq.quantity());
            productEcomRepository.save(product);
            
            OrderItem orderItem = OrderItem.builder().product(product)
            .quantity(itemreq.quantity())
            .price(product.getPrice() * itemreq.quantity())
            .order(order)
            .build();

            orderItems.add(orderItem);
        }
        order.setItems(orderItems);
        Order savedOrder =orderRepository.save(order);

        List<OrderItemResponse> itemResponses = new ArrayList<>();
        for (OrderItem item: order.getItems()){
            OrderItemResponse orderItemResponse = new OrderItemResponse(
                item.getProduct().getProductName(),
                item.getQuantity(),
                item.getPrice()
            );
            itemResponses.add(orderItemResponse);
        }

        OrderResponse orderResponse =new OrderResponse(
                savedOrder.getOrderId(),
                savedOrder.getName(),
                savedOrder.getEmail(),
                savedOrder.getStatus(),
                savedOrder.getOrderdate(),
                itemResponses
         );
        return orderResponse;
    }

    public List<OrderResponse> getAllOrders() {
        List<OrderResponse> responses = new ArrayList<>();
        List<Order> orders = orderRepository.findAll();
        for(Order order:orders){
            List<OrderItemResponse> orderItemResponses = new ArrayList<>();
            for(OrderItem orderItem:order.getItems()){
                OrderItemResponse orderItemResponse = new OrderItemResponse(
                    orderItem.getProduct().getProductName(),
                    orderItem.getQuantity(),
                    orderItem.getPrice()
                );
                orderItemResponses.add(orderItemResponse);
            }
            OrderResponse orderResponse = new OrderResponse(
                order.getOrderId(),
                order.getName(),
                order.getEmail(),
                order.getStatus(),
                order.getOrderdate(),
                orderItemResponses
            );
            responses.add(orderResponse);


        }
        // System.out.println(orders);
        return responses;
    }


    
}
