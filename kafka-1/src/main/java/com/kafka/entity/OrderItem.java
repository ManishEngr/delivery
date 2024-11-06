package com.kafka.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @NotNull(message = "Product ID is required")
    private Integer productId;

    @NotBlank(message = "Product name is required")
    @Size(max = 100, message = "Product name must be at most 100 characters")
    private String productName;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    @NotNull(message = "Price is required")
   
    private BigDecimal price;

    @NotNull(message = "Total price is required")
    
    private BigDecimal totalPrice;
}