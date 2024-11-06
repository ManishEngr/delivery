package com.delivery.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryId;

    private Long orderId;
    private String customerName;
    private String deliveryStatus = "PENDING";
    private String deliveryAddress;
    private LocalDateTime estimatedDeliveryDate;
   
}

