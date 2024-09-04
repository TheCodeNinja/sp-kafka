package com.example.demo.producer;

import com.example.demo.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentProducer {

    private static final String PAYMENT_TOPIC = "payments";

    @Autowired
    private KafkaTemplate<String, Payment> kafkaTemplate;

    @PostMapping("/payment")
    public String publishPayment(@RequestBody Payment payment) {
        payment.setStatus("PENDING");
        kafkaTemplate.send(PAYMENT_TOPIC, payment.getPaymentId(), payment);
        return "Payment published successfully!";
    }
}