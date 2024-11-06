package com.kafka.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @NotBlank(message = "Customer name is required")
    @Size(max = 100, message = "Customer name must be at most 100 characters")
    private String customerName;

    @NotBlank(message = "Customer email is required")
    @Email(message = "Customer email should be valid")
    @Size(max = 100, message = "Customer email must be at most 100 characters")
    private String customerEmail;

    @NotBlank(message = "Customer phone is required")
    private String customerPhone;

    @NotNull(message = "Total amount is required")
    private BigDecimal totalAmount;

    @NotNull(message = "Status is required")
    @Size(max = 20, message = "Status must be at most 20 characters")
    private String status = "PENDING";

    @NotEmpty(message = "Order must contain at least one item")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderItem> items;
    
}
