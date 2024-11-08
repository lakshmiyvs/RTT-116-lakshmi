package org.example;


import org.example.database.dao.CustomerDAO;
import org.example.database.dao.OrderDAO;
import org.example.database.dao.OrderDetailDAO;
import org.example.database.dao.ProductDAO;
import org.example.database.entity.Customer;
import org.example.database.entity.Order;
import org.example.database.entity.OrderDetail;
import org.example.database.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class HibernateDemo {
    public static void main(String[] args) {

       // SessionFactory factory = new Configuration().configure().buildSessionFactory();
       // Session session = factory.openSession();
        ProductDAO productDao = new ProductDAO();
        CustomerDAO customerDao = new CustomerDAO();
        OrderDAO orderDAO = new OrderDAO();
        OrderDetailDAO orderdetailDAO = new OrderDetailDAO();

        // find a specific product by id
        Product p = productDao.findById(1);
        System.out.println(p);

        Customer c = customerDao.findById(103);
        System.out.println(c);

        // find all products with the name ford
        List<Product> fords = productDao.search("Ford");
        for ( Product ford : fords ) {
            System.out.println(ford);
        }

        List<Customer> Microscale = customerDao.search("Microscale");
        for ( Customer n : Microscale ) {
            System.out.println(n);
        }

       // Order o = orderDAO.findById(10100);
        System.out.println(orderDAO.findById(10100));

        OrderDetail od = orderdetailDAO.findById(1);
        System.out.println(od);



    }
}