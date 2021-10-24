# Simple App that accepts a file via RESTful API and stored the records in Postgres database.

## File upload API 
* curl -X POST "http://localhost:8082/order/upload/v1" -H "accept: application/json" -H "Content-Type: multipart/form-data" -F "file=@Order.csv;type=text/csv"

**Pull Docker image by issuing the below command**

docker pull bobiologist/file-api:latest

## Build docker Image 
* docker build . -t fileapi:latest
* 
* docker-compose up
* Create the below table 

```SQL
 CREATE TABLE IF NOT EXISTS public."orders"
(
	id SERIAL PRIMARY KEY,
    orderId text UNIQUE NOT NULL,
    region text,
	country text,
    itemType text,
    salesChannel text,
    orderPriority text,
    orderDate text,
    shipDate text,
    unitsSold integer,
    unitPrice float,
    unitCost float, 
    totalRevenue float,
    totalCost float,
    totalProfit float,
    creationDate timestamp with time zone DEFAULT now()
);
```

