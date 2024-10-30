select * from products;
select * from productlines;
select * from orderdetails;
select * from payments;
select * from customers;
select * from orders;
select * from offices;

-- I want to see the name of the product line and all product names in that product line
 -- order by the product line name then by the product name
select pl.product_line, pd.product_name
from productlines pl, products pd
where pl.id = pd.productline_id
order by pl.product_line, pd.product_name;

-- 2. I want to see the order number, the product name, and the quantity ordered
-- order by the order number (descending), then the product name (ascending) , then the quantity ordered ( fewest first)
select od.order_id, pd.product_name, od.quantity_ordered
from orderdetails od, products pd
where od.product_id = pd.id
order by od.order_id desc, pd.product_name, od.quantity_ordered;

-- 3. I want to see all payments made by customers.  The result should show the customer name, the check number, payment date, and the amount.
## I want the result set ordered by the customer name (ascending), the payment date ( descending  newest first)
select c.customer_name, py.check_number, py.payment_date, py.amount
from customers c, payments py
where py.customer_id = c.id
order by c.customer_name , py.payment_date desc;

-- 4.  I want to see the orders and all products in that order - order number and product name---
-- order by the order number ascending and the product name descending.
select od.order_id, pd.product_name
from products pd, orderdetails od
where od.product_id = pd.id
order by od.order_id, pd.product_name desc;

-- I want to see the number of products in each order -
-- I want to see the order id and the count of each product in that order ... order by count(*) desc
select order_id, count(*)
from orderdetails
group by order_id
order by count(*) desc;

-- I want to see the customer that has made most payments (group by customer_id)
select customer_id, count(*)
from payments
group by customer_id
order by count(*) desc;

--  I want to see the order that has the most products ( group by order_id)
select order_id, count(*)
from orderdetails
group by order_id
order by count(*) desc;

-- BONUS .... I want to see the total quantity ordered for each order ... we have not learned this yet ..
-- but it group by the order_id and sum(quanity_ordered)
select order_id, sum(quantity_ordered)
from orderdetails
group by order_id;

-- I want to see the employee first name and last name and the customer name ordered by the customer name
select * from employees;
select * from customers;

select e.firstname, e.lastname, c.customer_name
from employees e, customers c
where e.id = c.sales_rep_employee_id
order by c.customer_name;
