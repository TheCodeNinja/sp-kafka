package com.example.demo.service;

import com.example.demo.entity.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private final KafkaTemplate<String, Order> orderKafkaTemplate;

    public OrderService(KafkaTemplate<String, Order> orderKafkaTemplate) {
        this.orderKafkaTemplate = orderKafkaTemplate;
    }

    @Transactional(transactionManager = "orderTransactionManager")
    public void sendOrder(Order order) {
        orderKafkaTemplate.send("order-topic", order.getOrderId(), order);
    }
}