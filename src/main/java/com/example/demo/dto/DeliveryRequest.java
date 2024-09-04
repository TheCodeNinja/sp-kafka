package com.example.demo.dto;

import com.example.demo.entity.Order;
import lombok.Data;

@Data
public class DeliveryRequest {

    private String orderId;
    private String product;
    private int quantity;
    private String address; // Assume order has an address field

    public DeliveryRequest(Order order) {
        this.orderId = order.getOrderId();
        this.product = order.getProduct();
        this.quantity = order.getQuantity();
        this.address = order.getAddress();
    }

}