package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "`order`")
public class Order {
    @Id
    private String orderId;
    private String product;
    private int quantity;
    private String status;
    private String customerEmail;
    private String address;
}