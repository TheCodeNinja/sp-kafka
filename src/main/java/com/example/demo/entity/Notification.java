package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Notification {
    @Id
    private String notificationId;
    private String orderId;
    private String message;
    private String departmentEmail;

}