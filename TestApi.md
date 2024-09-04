
```bash
curl -X POST http://localhost:8080/order \
-H "Content-Type: application/json" \
-d '{
  "orderId": "1",
  "product": "Widget",
  "quantity": 10,
  "customerEmail": "customer@example.com",
  "address": "123 Main St"
}'
```