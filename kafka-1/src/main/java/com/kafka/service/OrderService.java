package com.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.dto.OrderRequest;
import com.kafka.dto.ResponseWrapper;
import com.kafka.entity.Order;
import com.kafka.repostitory.OrderRepository;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public ResponseEntity<ResponseWrapper<Order>> createOrder(OrderRequest orderRequest) {
       
        Order order = new Order();
        order.setCustomerName(orderRequest.getCustomerName());
        order.setCustomerEmail(orderRequest.getCustomerEmail());
        order.setCustomerPhone(orderRequest.getCustomerPhone());
        order.setTotalAmount(orderRequest.getTotalAmount());
        order.setStatus("PENDING"); 

       
        Order savedOrder = orderRepository.save(order);
        
        
        kafkaTemplate.send("order-topic", savedOrder);

        
        ResponseWrapper<Order> response = new ResponseWrapper<>(
                "Order Placed Successfully",
                "Your order has been created and is now being processed.",
                savedOrder
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
