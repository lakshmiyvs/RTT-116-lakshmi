select * from customers;
select * from employees;
select c.customer_name as 'Customer Name', concat(e.lastname, ', ', e.firstname) as 'Sales Rep'
from customers c JOIN employees e 
on c.sales_rep_employee_id = e.id
order by c.customer_name asc;

select * from products;
select * from orderdetails;
select * from orders;
select p.product_name as 'Product Name', sum(od.quantity_ordered) as 'Total # Ordered', sum(od.quantity_ordered * od.price_each) as 'Total Sale'
from products p LEFT JOIN orderdetails od 
on p.id=od.product_id
group by p.product_name, p.buy_price
order by 3 desc;

select status as 'Order Status', count(status) as 'Total Orders'
from orders
group by status
order by status;


select * from products;
select * from productlines;
select 
     pl.product_line as 'Product Line', 
     count(od.product_code) as 'total Sold'
from productlines pl join products p 
on pl.product_line=p.productline_id
 JOIN orderdetails od on  p.id=od.product_id
group by pl.product_line
order by 2 desc;

select * from hr;

select * from employees;
SELECT * FROM employees WHERE Id NOT IN(
    SELECT Id FROM employees WHERE departmentId = 14
);

select p.id from orderdetails od join products p on p.id = od.product_id
where order_id = 10100;

select o.* from orderdetails od join orders o on o.id = od.order_id
where od.product_id = 27;

select * from orderdetails;
select * from orderdetails order by id desc;

select * from products where product_name ="Test Product30";

select * from productlines;
