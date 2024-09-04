package com.example.demo.consumer;

import com.example.demo.entity.Inventory;
import com.example.demo.entity.Notification;
import com.example.demo.entity.Order;
import com.example.demo.entity.Payment;
import com.example.demo.producer.NotificationProducer;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.repository.NotificationRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderConsumer {

    private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private NotificationProducer notificationProducer;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    // Validate order and check inventory
    @KafkaListener(topics = "orders", groupId = "order-validation", concurrency = "3")
    @Transactional
    public void validateOrder(Order order) {
        logger.info("Validating order: {}", order.getOrderId());
        kafkaTemplate.executeInTransaction(operations -> {
            Inventory inventory = inventoryRepository.findById(order.getProduct()).orElse(null);
            if (inventory != null && inventory.getStock() >= order.getQuantity()) {
                order.setStatus("VALIDATED");
                inventory.setStock(inventory.getStock() - order.getQuantity());
                inventoryRepository.save(inventory);
                notificationProducer.sendNotification(createNotification(order.getOrderId(), "sales@company.com", "Order validated and awaiting payment."));
            } else {
                order.setStatus("REJECTED");
                logger.warn("Order rejected due to insufficient stock: {}", order.getOrderId());
            }
            orderRepository.save(order);
            return true;
        });
    }

    @Transactional
    @KafkaListener(topics = "payments", groupId = "payment-processing", concurrency = "3")
    public void processPayment(Payment payment) {
        logger.info("Processing payment: {}", payment.getPaymentId());
        kafkaTemplate.executeInTransaction(operations -> {
            Order order = orderRepository.findById(payment.getOrderId()).orElse(null);
            if (order != null && "VALIDATED".equals(order.getStatus())) {
                payment.setStatus("COMPLETED");
                order.setStatus("PAID");
                processPaidOrder(order);
            } else {
                payment.setStatus("FAILED");
                logger.warn("Payment failed for order: {}", payment.getOrderId());
            }
            paymentRepository.save(payment);
            orderRepository.save(order);
            return true;
        });
    }

    private void processPaidOrder(Order order) {
        logger.info("Delivering order: {}", order.getOrderId());
        order.setStatus("DELIVERED");
        notificationProducer.sendNotification(createNotification(order.getOrderId(), "finance@company.com", "Payment received for order."));
        notificationProducer.sendNotification(createNotification(order.getOrderId(), "delivery@company.com", "Order has been delivered."));
        notificationProducer.sendOrderToDelivery(order);
        orderRepository.save(order);
    }

    private Notification createNotification(String orderId, String departmentEmail, String message) {
        Notification notification = new Notification();
        notification.setNotificationId(orderId + "-notification");
        notification.setOrderId(orderId);
        notification.setMessage(message);
        notification.setDepartmentEmail(departmentEmail);
        return notification;
    }
}