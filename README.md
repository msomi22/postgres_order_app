# postgres_order_app
curl -X POST "http://localhost:8082/order/upload/v1" -H "accept: application/json" -H "Content-Type: multipart/form-data" -F "file=@Order.csv;type=text/csv"
