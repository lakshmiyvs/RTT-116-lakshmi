package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.OrderDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrderDetailDAO {

    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void update(OrderDetail orderdetail) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        try {
            session.merge(orderdetail);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.close();

    }

    public void create(OrderDetail orderdetail) {
        Session session = factory.openSession();
        // starting a database transaction
        session.getTransaction().begin();

        // in an older style of hibernate we need to use the persist function when we want to create a new record
        session.persist(orderdetail);
        session.getTransaction().commit();
        session.close();
    }


    public void delete(OrderDetail orderdetail) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.delete(orderdetail);
        session.getTransaction().commit();
        session.close();

    }

    public void deleteById(int id) {
        Session session = factory.openSession();
        session.beginTransaction();
        OrderDetail orderdetail = (OrderDetail) session.get(OrderDetail.class, id);
        session.delete(orderdetail);
        session.getTransaction().commit();
        session.close();
    }

    // below here is our queries
    //** This query gets created in every single DAO make**
    public OrderDetail findById(Integer id) {

        String hqlQuery = "Select od from OrderDetail od where od.id = :orderdetailid";

        Session session = factory.openSession();

        TypedQuery<OrderDetail> query = session.createQuery(hqlQuery, OrderDetail.class);

        query.setParameter("orderdetailid", id);

        try {
            OrderDetail result = query.getSingleResult();
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            // have to close this session at the end which tells hibernate to give back it to the pool
            session.close();
        }


    }




    }