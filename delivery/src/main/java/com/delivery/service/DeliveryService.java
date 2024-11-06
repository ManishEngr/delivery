package com.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.entity.Delivery;
import com.delivery.repository.DeliveryRepository;


@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public void saveDelivery(Delivery delivery) {
        deliveryRepository.save(delivery);
    }
}
