--- Join and Group by
---- how many employees are in each office .... I want to see the office name and the count of the employees in that office
---- group by is called an aggregate function because we can make things into groups and then find information about that group
select * from employees;
select * from offices;

-- step 1 just get the count of the office

select office_id, count(*)
from employees
group by office_id;

----- step 2

select o.city, office_id, count(*)
 from employees e, offices o
 where e.office_id = o.id
group by office_id;

select firstname, count(*) from employees 
group by firstname;

select firstname, job_title, reports_to from employees where reports_to = '1002'; 


########## find the employees with the most customers
select sales_rep_employee_id, count(*) 
from customers c
group by sales_rep_employee_id
order by count(*) desc;

select e.firstname, e.lastname, sales_rep_employee_id, count(*) 
from customers c, employees e
where c.sales_rep_employee_id = e.id
group by sales_rep_employee_id
order by count(*) desc
limit 3;

######## i want to see a list of all customers for the San Fransisco office
select e.firstname, e.lastname, o.city, c.customer_name, c.contact_firstname, c.contact_lastname
from offices o, employees e, customers c
where o.id = 2
	and e.office_id = o.id
    and c.sales_rep_employee_id = e.id;
    
---##### i want to see all customers the sales rep and the office name
select e.firstname, e.lastname, o.city, c.customer_name, c.contact_firstname, c.contact_lastname
from offices o, employees e, customers c
where e.office_id = o.id 
	  and c.sales_rep_employee_id = e.id; 
      
-----##### i want to see all of the customers that have made an order and I want to see the customer name , the office, employee name and order id, and order date
 select e.firstname, e.lastname, o.city, c.customer_name, c.contact_firstname, c.contact_lastname, ord.id as order_id, ord.order_date
from offices o, employees e, customers c, orders ord
where e.office_id = o.id 
	  and c.sales_rep_employee_id = e.id  
      and ord.customer_id = c.id
order by e.id, customer_name;   


------#### I want to see all the list of all the products purchased- I want to see the customer name, the office, the emplyee name, the order id, and

select e.firstname, e.lastname, o.city, c.customer_name, c.contact_firstname, c.contact_lastname, ord.id as order_id, ord.order_date, od.product_id, od.quantity_ordered
from offices o, employees e, customers c, orders ord, orderdetails od
where e.office_id = o.id 
	  and c.sales_rep_employee_id = e.id  
      and ord.customer_id = c.id
      and od.order_id = ord.id
order by e.id, customer_name, order_id;     


----##### Everything from the previous report.... now I want to add the product name
--- 3 Steps for joining 
--- 1 . Add the table to the from clause
--- 2. Join the tables in the where clause
--- 3. Add any columns desired to the select part of the query
select * from products;
select e.firstname, e.lastname, o.city, c.customer_name, c.contact_firstname, c.contact_lastname, ord.id as order_id, ord.order_date, od.product_id, od.quantity_ordered, p.product_name
from offices o, employees e, customers c, orders ord, orderdetails od, products p
where e.office_id = o.id 
	  and c.sales_rep_employee_id = e.id  
      and ord.customer_id = c.id
      and od.order_id = ord.id
      and od.product_id = p.id
order by e.id, customer_name, order_id, product_id;  

----- I want to see all the products that have been ordered and how many times each product has been ordered ( note this is different than the quantity ordered)
------ and I want to see the products that was ordered the most on top
------ and in the report I want to see the order number,  and the number of times the product was ordered
------ hint 1 - the orderdetail table will contain 1 record for each time the product was ordered
------ hint 2 needs a group by
select od.order_id as order_number, count(*)
from products p, orderdetails od
where od.product_id = p.id
group by od.order_id
order by order_number;

select * from orderdetails where order_id = 10102 order by id;
select * from products;

