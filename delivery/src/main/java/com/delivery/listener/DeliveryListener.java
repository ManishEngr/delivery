package com.delivery.listener;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.delivery.dto.Order;
import com.delivery.entity.Delivery;
import com.delivery.service.DeliveryService;

@Component
public class DeliveryListener {

    @Autowired
    private DeliveryService deliveryService;

    @KafkaListener(topics = "order-topic", groupId = "delivery-group")
    public void consumeOrder(Order order) {
     
        Delivery delivery = new Delivery();
        delivery.setOrderId(order.getOrderId());
        delivery.setCustomerName(order.getCustomerName());
        delivery.setDeliveryAddress("Varanasi"); 
        delivery.setEstimatedDeliveryDate(LocalDateTime.now().plusDays(5));  
        delivery.setDeliveryStatus("SHIPPED");

       
        deliveryService.saveDelivery(delivery);
    }
}