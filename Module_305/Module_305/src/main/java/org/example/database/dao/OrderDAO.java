package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.Order;
import org.example.database.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class OrderDAO {

    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void update(Order order) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        try {
            session.merge(order);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.close();

    }

    public void create(Order order) {
        Session session = factory.openSession();
        // starting a database transaction
        session.getTransaction().begin();

        // in an older style of hibernate we need to use the persist function when we want to create a new record
        session.persist(order);
        session.getTransaction().commit();
        session.close();
    }


    public void delete(Order order) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.delete(order);
        session.getTransaction().commit();
        session.close();

    }

    public void deleteById(int id) {
        Session session = factory.openSession();
        session.beginTransaction();
        Order order = (Order) session.get(Order.class, id);
        session.delete(order);
        session.getTransaction().commit();
        session.close();
    }

    // below here is our queries
    //** This query gets created in every single DAO make**
    public Order findOrderById(Integer id) {

        Session session = factory.openSession();

        String hqlQuery = "Select o from Order o where o.id = :orderid";


        TypedQuery<Order> query = session.createQuery(hqlQuery, Order.class);

        query.setParameter("orderid", id);

        try {
            Order result = query.getSingleResult();
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            // have to close this session at the end which tells hibernate to give back it to the pool
            session.close();
        }


    }

    public List<Product> findByProductId(Integer id) {

        String hqlQuery = "select p from OrderDetail od join Product p on p.id = od.productId where od.orderId= :orderid";

        Session session = factory.openSession();

        TypedQuery<Product> query = session.createQuery(hqlQuery, Product.class);

        query.setParameter("orderid", id);

        try {
            List<Product> result = query.getResultList();
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            // have to close this session at the end which tells hibernate to give back it to the pool
            session.close();
        }


    }

    //public List<Order> search(String name) {

    //    String hqlQuery = "Select o from Order o where o.orderName LIKE concat('%',:name, '%') order by o.customerId";

    //    Session session = factory.openSession();

    //    TypedQuery<Order> query = session.createQuery(hqlQuery, Order.class);

    //    query.setParameter("name", name);

    //    try {
    //        List<Order> result = query.getResultList();
    //        return result;
    //    } catch (Exception e) {
    //        return null;
    //    } finally {
    //        session.close();
   //     }


    }


