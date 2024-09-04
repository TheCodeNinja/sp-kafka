package com.example.demo.consumer;

import com.example.demo.entity.Notification;
import com.example.demo.repository.NotificationRepository;
import com.example.demo.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    private static final Logger logger = LoggerFactory.getLogger(NotificationConsumer.class);

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = "notifications", groupId = "notification-processing", concurrency = "3")
    public void processNotification(Notification notification) {
        logger.info("Processing notification for order: {}", notification.getOrderId());
        notificationRepository.save(notification);
        emailService.sendEmail(notification.getDepartmentEmail(), "Notification", notification.getMessage());
        logger.info("Notification processed for order: {}", notification.getOrderId());
    }
}