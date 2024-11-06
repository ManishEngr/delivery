package com.kafka.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafka.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {}
