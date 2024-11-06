package com.delivery.dto;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class Order {

    private Long orderId;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private BigDecimal totalAmount;
}
