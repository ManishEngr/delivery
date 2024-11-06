package com.kafka.dto;

import java.math.BigDecimal;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
@Data
public class OrderRequest {
    
    @NotBlank(message = "Customer name is required")
    private String customerName;

    @NotBlank(message = "Customer email is required")
    @Email(message = "Invalid email format")
    private String customerEmail;

    @NotBlank(message = "Customer phone is required")
    private String customerPhone;

   
    private BigDecimal totalAmount;

    @NotEmpty(message = "Order must contain at least one item")
    private List<OrderItemRequest> items;
    
}
