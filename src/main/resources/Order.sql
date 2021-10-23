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
