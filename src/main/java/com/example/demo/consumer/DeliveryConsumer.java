package com.example.demo.consumer;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.DeliveryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DeliveryConsumer {

    private static final Logger logger = LoggerFactory.getLogger(DeliveryConsumer.class);

    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private OrderRepository orderRepository;

    @KafkaListener(topics = "delivery-orders", groupId = "delivery-processing", concurrency = "3")
    public void processDeliveryOrder(Order order) {
        logger.info("Processing delivery for order: {}", order.getOrderId());
        try {
            // Call delivery service to process the delivery
            deliveryService.processDelivery(order);

            // Update order status to 'DELIVERED'
            order.setStatus("DELIVERED");
            orderRepository.save(order);

            logger.info("Order delivery processed successfully: {}", order.getOrderId());
        } catch (Exception e) {
            logger.error("Failed to process delivery for order: {}", order.getOrderId(), e);
            // Optionally, update order status to 'DELIVERY_FAILED'
            order.setStatus("DELIVERY_FAILED");
            orderRepository.save(order);
        }
    }
}