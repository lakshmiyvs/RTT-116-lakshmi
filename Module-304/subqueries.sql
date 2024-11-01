--  Lets see if there are any prdocut lines that have never had a product ordered
select * from products;

select *
from productlines pl
where pl.id not in ( select p.productline_id from products p, orderdetails od where p.id = od.product_id );


select distinct p.productline_id from products p, orderdetails od where p.id = od.product_id;

INSERT INTO `classic_models`.`productlines`
(
`product_line`,
`description`)
VALUES
(
'Test Line',
'Just for this class');