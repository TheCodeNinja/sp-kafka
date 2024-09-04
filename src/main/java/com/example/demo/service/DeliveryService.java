package com.example.demo.service;

import com.example.demo.dto.DeliveryRequest;
import com.example.demo.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeliveryService {

    private static final Logger logger = LoggerFactory.getLogger(DeliveryService.class);

    @Autowired
    private RestTemplate restTemplate;

    public void processDelivery(Order order) {
        // Simulate delivery processing by calling an external delivery API
        String deliveryApiUrl = "https://api.example.com/delivery";

        DeliveryRequest deliveryRequest = new DeliveryRequest(order);

        try {
            restTemplate.postForObject(deliveryApiUrl, deliveryRequest, String.class);
            logger.info("Delivery API called successfully for order: {}", order.getOrderId());
        } catch (Exception e) {
            logger.error("Error calling delivery API for order: {}", order.getOrderId(), e);
            throw new RuntimeException("Delivery processing failed");
        }
    }
}