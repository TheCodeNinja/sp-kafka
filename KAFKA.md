To make this Kafka-based system more practical and production-ready, we'll incorporate advanced Kafka concepts and business logic. This includes error handling, retries, logging, monitoring, and more detailed business processes.

### Key Enhancements

1. **Transactional Messaging**: Use `KafkaTemplate` transactions to ensure atomic operations.
2. **Error Handling**: Retry logic with a simple retry policy and error handling.
3. **Logging**: Use SLF4J for structured logging.
4. **Security**: Consider adding security settings (e.g., SSL, SASL) for Kafka in production.
5. **Monitoring**: Integrate with tools like Prometheus or Grafana for monitoring Kafka metrics.

### Running the Application

1. Ensure Kafka topics have multiple partitions.
2. Set up email server or SMTP.
3. Run your Spring Boot application.
4. Use tools like Postman to send POST requests to `/order` and `/payment`.
5. Monitor logs and email notifications for processing status.

To set up your Kafka application using Docker and test it, follow these steps:

### Step 1: Docker Compose YAML for Kafka

Here's the Docker Compose file for running Kafka in KRaft mode on Docker Desktop:

```yaml
version: '3.8'
services:
  kafka:
    image: bitnami/kafka:latest
    ports:
      - "9092:9092"
    environment:
      - KAFKA_CFG_PROCESS_ROLES=broker,controller
      - KAFKA_CFG_NODE_ID=1
      - KAFKA_CFG_CONTROLLER_QUORUM_VOTERS=1@1
      - KAFKA_CFG_LISTENERS=PLAINTEXT://0.0.0.0:9092
      - KAFKA_CFG_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092
      - KAFKA_CFG_OFFSETS_TOPIC_REPLICATION_FACTOR=1
      - KAFKA_CFG_TRANSACTION_STATE_LOG_REPLICATION_FACTOR=1
      - KAFKA_CFG_TRANSACTION_STATE_LOG_MIN_ISR=1
      - KAFKA_CFG_AUTO_CREATE_TOPICS_ENABLE=false
    volumes:
      - kafka_data:/bitnami/kafka
    deploy:
      resources:
        limits:
          cpus: '0.50'
          memory: 512M

volumes:
  kafka_data:
```

### Step 2: Create Topics

Since auto-creation is disabled, you'll need to create the topics manually:

1. **Run the Kafka container:**

   ```bash
   docker-compose up -d
   ```

2. **Access the Kafka container:**

   ```bash
   docker exec -it <container_id> /bin/bash
   ```

3. **Create topics:**

   ```bash
   kafka-topics.sh --create --topic orders --bootstrap-server localhost:9092 --partitions 3 --replication-factor 1
   kafka-topics.sh --create --topic payments --bootstrap-server localhost:9092 --partitions 3 --replication-factor 1
   ```

### Step 3: API Endpoints for Testing

Use these endpoints to test the application:

#### Order Endpoint

```java
@PostMapping("/order")
public String publishOrder(@RequestBody Order order) {
    order.setStatus("PENDING");
    kafkaTemplate.send("orders", order.getOrderId(), order);
    return "Order published successfully!";
}
```

#### Payment Endpoint

```java
@PostMapping("/payment")
public String publishPayment(@RequestBody Payment payment) {
    payment.setStatus("PENDING");
    kafkaTemplate.send("payments", payment.getPaymentId(), payment);
    return "Payment published successfully!";
}
```

#### Consumer Classes

- **`@KafkaListener` Annotations**: Listen to the respective topics with a concurrency setting for parallel processing.

#### Configuration

- Ensure your `application.properties` or `application.yml` is set to connect to Kafka:

  ```properties
  spring.kafka.bootstrap-servers=localhost:9092
  ```

### Step 4: SQL Script with Dummy Data

Create tables and insert dummy data:

```sql
CREATE TABLE orders (
    order_id VARCHAR(255) PRIMARY KEY,
    product VARCHAR(255),
    quantity INT,
    status VARCHAR(255),
    customer_email VARCHAR(255)
);

CREATE TABLE payments (
    payment_id VARCHAR(255) PRIMARY KEY,
    order_id VARCHAR(255),
    amount DOUBLE,
    status VARCHAR(255)
);

CREATE TABLE inventory (
    product_id VARCHAR(255) PRIMARY KEY,
    stock INT
);

CREATE TABLE notifications (
    notification_id VARCHAR(255) PRIMARY KEY,
    order_id VARCHAR(255),
    message VARCHAR(255),
    department_email VARCHAR(255)
);

INSERT INTO inventory (product_id, stock) VALUES ('product1', 100);
INSERT INTO inventory (product_id, stock) VALUES ('product2', 200);
```

### Step 5: Testing the Application API

1. **Run your Spring Boot application** using your IDE or build tool (Maven/Gradle).

2. **Test the API endpoints** using a tool like Postman or `curl`.

    - **Order Endpoint:**

      ```bash
      curl -X POST -H "Content-Type: application/json" -d '{"orderId": "123", "product": "book"}' http://localhost:8080/order
      ```

    - **Payment Endpoint:**

      ```bash
      curl -X POST -H "Content-Type: application/json" -d '{"paymentId": "456", "amount": 100}' http://localhost:8080/payment
      ```

### Step 6: Monitoring

- **Logs**: Check your application and Kafka container logs for any errors or confirmation messages.
- **Kafka Tools**: Use Kafka management tools like Confluent Control Center or Kafdrop for monitoring.

This setup allows you to test your Kafka-based application locally with Docker Desktop. Adjust the configurations as needed for your environment.