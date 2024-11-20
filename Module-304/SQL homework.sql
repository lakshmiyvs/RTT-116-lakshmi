select * from products;
select * from productlines;
select * from orderdetails;
select * from payments;
select * from customers;
select * from orders;
select * from offices;

-----## product line name by product name
select pl.product_line, pd.product_name 
from productlines pl, products pd
where pl.id = pd.productline_id
order by pl.product_line, pd.product_name;

------##
select od.order_id, pd.product_name, od.quantity_ordered
from orderdetails od, products pd
where od.product_id = pd.id
order by od.order_id desc, pd.product_name, od.quantity_ordered;

-----## customer payments
select c.customer_name, py.check_number, py.payment_date, py.amount
from customers c, payments py
where py.customer_id = c.id
order by c.customer_name , py.payment_date desc;

-----## orders
select od.order_id, pd.product_name
from products pd, orderdetails od
where od.product_id = pd.id
order by od.order_id, pd.product_name desc;

-----## no of products
select order_id, count(*) as cnt, sum(quantity_ordered) as total_quantity, max(quantity_ordered) as max, min(quantity_ordered),
avg(price_each), max(price_each)
from orderdetails 
group by order_id
order by count(*) desc;

-----###I want to see the customer that has made most payments (group by customer_id)
select customer_id, count(*)
from payments
group by customer_id
order by count(*) desc;

-----## I want to see the office that has has the most orders (group by office_id)
---# when grouping by the primary key ---- we can get individual 
select o.id, o.city, count(distinct e.id) as employees, count(distinct c.id) as customer_count, count(*) as order_count
from offices o, employees e, customers c, orders ord
where o.id = e.office_id
	and e.id = c.sales_rep_employee_id
    and c.id = ord.customer_id
    and year(ord.order_date) = 2003 and month(ord.order_date) = 6
--    and c.customer_name like 'A%'
group by o.id, year(ord.order_date)
-- having is very much like a where clause accept that it only works on the agreegate function
having count(distinct e.id) > 1
order by count(*) desc;


-----## BONUS .... I want to see the total quantity ordered for each order ... we have not learned this yet .. 
----##but it group by the order_id and sum(quanity_ordered)
select order_id, sum(quantity_ordered)
from orderdetails
group by order_id;
 
 -----##I want to see the employee first name and last name and the customer name ordered by the customer name
select * from employees;
select * from customers;

select e.firstname, e.lastname, c.customer_name
from employees e, customers c
where e.id = c.sales_rep_employee_id
order by c.customer_name;

-----## I want to see the count of all orders by office 

select od.order_id, o.id, count(*)
from offices o, employees e, customers c, orders ord, orderdetails od
where od.order_id = o.id
	and e.id = c.sales_rep_employee_id
    and c.id = ord.customer_id
    and e.office_id = o.id
group by o.id;



