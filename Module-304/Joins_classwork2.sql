-- lets calculate the total profit for an order 10100
select p.product_name, p.buy_price, od.quantity_ordered, od.price_each as sale_price, (price_each - buy_price) as product_margin,
	quantity_ordered * (price_each - buy_price) as line_item_margin
from products p, orderdetails od
where p.id = od.product_id AND od.order_id = 10100;

-- lets calculate the total profit for all orders
select od.order_id, sum(quantity_ordered * price_each - buy_price) as total_price
from products p, orderdetails od
where p.id = od.product_id 
group by od.order_id;

-- lets calculate total profit by month
select year(o.order_date), month(o.order_date), sum(quantity_ordered * (price_each - buy_price)) as total_profit
from products p, orderdetails od, orders o
where p.id = od.product_id and od.order_id = o.id
group by year(o.order_date), month(o.order_date);

select current_date();
select now();
select * from orders
where order_date < current_date();

select ifnull(comments, 'Replace Comment')
from orders;

-- this is a wrong query
select * from orders where comments = null;
-- this is to check if something is null
select * from orders where comments is null;
select * from orders where comments is not null;

select * from orders where id != 10107;

-- SBA question
SELECT product_name, buy_price, 
CASE
	WHEN buy_price > 80 AND buy_price <=  50 THEN "LOW PRICE"
	WHEN buy_price >= 50 AND buy_price <= 100 THEN "Medium Price"
	WHEN buy_price > 100 AND buy_price <= 200 THEN "high Price"
ELSE "Out of our rang" END AS price_status 
FROM products 
where buy_price > 9
ORDER BY buy_price DESC;

-- in operates like an OR in this case will return any row matching any of 3 cities
select * from customers;
select * from customers where city in ('Las Vegas', 'Nantes', 'Frankfurt');
select * from customers where city = 'Las Vegas' or city = 'Nantes' or city = 'Frankfurt';

--
select id from customers where id in (103, 112, 119);
select id from customers where customer_name like 'A%';
select * from orders where customer_id in (select id from customers where id in (103, 112, 119));

select * 
from orders o,
	( select id from customers where customer_name like 'A%' ) as c
where o.customer_id = c.id;   

select * 
from orders o,
( select id from customers where customer_name like 'A%' ) as c
where o.customer_id = c.id; 

----##Homework 2 which product did we sell the most of? number of orders, the total amount sold, and the product name 
select p.product_name, count(od.order_id), sum(od.quantity_ordered * od. price_each)
from products p, orderdetails od
where p.id = od.product_id
group by p.product_name;

----## Homework 2
select year(o.order_date), p.product_name, sum(od.quantity_ordered * (od. price_each - p.buy_price)) as profit
from products p, orderdetails od, orders o
where o.id = od.order_id and p.id = od.product_id
group by year(o.order_date), p.product_name
order by year(o.order_date) desc, profit desc;

--------- LEFT JOIN----------

select * from customers where id = 125;
select * from orders where customer_id = 125;

-- this is the left join syntax for 2 tables
SELECT  c.id as customer_id,  c.customer_name, o.id as order_id, o.status
FROM customers c
LEFT JOIN orders o ON c.id = o.customer_id;

-- this is a regular query (this is an inner join)
SELECT  c.id as customer_id,  c.customer_name, o.id as order_id, o.status
FROM customers c, orders o
where c.id = o.customer_id
order by c.id;

-- this is the same regular query accept using the MySQL syntax 
-- this is the same as above accept using the inner join syntax from mysql
SELECT  c.id as customer_id,  c.customer_name, o.id as order_id, o.status
FROM customers c
INNER JOIN orders o ON c.id = o.customer_id
order by c.id;

-- this is a regular query ( this is an inner join)
select c.id as customer_id, c.customer_name, o.id as order_id, o.status
from customers c, orders o
where c.id = o.customer_id
order by c.id;

-- SELF JOIN--

select * from employees;
-- when doing a self join you use the same table in the from 2 times
-- self referencing table
select e.id, e.lastname, e.firstname, e.job_title, m.id as manager_id, m.lastname as manager_lastname, m.firstname as manager_firstname
from employees e, employees m
where e.reports_to = m.id

-- ============= UNION ==========
-- does get used from time to time
-- union does not include duplicates - meaning after merging the result sets there are no duplicates
-- union all includes duplicates

select * from customers where customer_name like 'A%'
union
select * from customers where customer_name like 'A%';

select phone from customers where customer_name like 'A%'
union
select firstname from employees;



select c.customer_name AS Customer, 
	SUM(od.quantity_ordered * od.price_each) AS Due, 
	COALESCE(SUM(p.amount), 0) AS Paid, 
	SUM(od.quantity_ordered * od.price_each) - COALESCE(SUM(p.amount), 0) AS Balance
FROM customers c
JOIN orders o on c.id = o.customer_id
JOIN orderdetails od ON o.id = od.order_id
LEFT JOIN payments p ON c.id = p.customer_id
GROUP BY c.id, c.customer_name
HAVING Balance > 0
ORDER BY Balance DESC;

select c.id, c.contact_firstname, c.contact_lastname, 
	sum(quantity_ordered * price_each) as total_purchase, total_payment,
	if(sum(quantity_ordered * price_each) > total_payment, (sum(quantity_ordered * price_each) - total_payment), 'No outstanding' ) as outstanding_balance 
from customers c, orderdetails od, orders o
where o.customer_id = c.id
    and od.order_id = o.id
group by c.id
order by c.id;

-- to use a query as a subtable
select c.customer_name, sum(od.quantity_ordered * od.price_each) as amount_purchased, (select sum(pm.amount) from payments pm where pm.customer_id = c.id) as amount_paid,
	sum(od.quantity_ordered * od.price_each) - (select sum(pm.amount) from payments pm where pm.customer_id = c.id) as balance
from customers c, orders o, orderdetails od
where 
o.customer_id = c.id
and od.order_id = o.id
group by o.customer_id;


SELECT 
    c.customer_name AS Customer, 
    od.total_due AS Due, 
    COALESCE(p.total_paid, 0) AS Paid, 
    od.total_due - COALESCE(p.total_paid, 0) AS Balance
FROM customers c
JOIN (
    SELECT o.customer_id, 
           SUM(od.quantity_ordered * od.price_each) AS total_due
    FROM orders o
    JOIN orderdetails od ON o.id = od.order_id
    GROUP BY o.customer_id
) od ON c.id = od.customer_id
LEFT JOIN (
    SELECT customer_id, 
           SUM(amount) AS total_paid
    FROM payments
    GROUP BY customer_id
) p ON c.id = p.customer_id
ORDER BY Balance DESC;