package com.example.demo.producer;

import com.example.demo.entity.Notification;
import com.example.demo.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {

    private static final Logger logger = LoggerFactory.getLogger(NotificationProducer.class);

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendNotification(Notification notification) {
        logger.info("Sending notification for order: {}", notification.getOrderId());
        kafkaTemplate.send("notifications", notification);
    }

    public void sendOrderToDelivery(Order order) {
        logger.info("Sending order to delivery department: {}", order.getOrderId());
        kafkaTemplate.send("delivery-orders", order);
    }
}