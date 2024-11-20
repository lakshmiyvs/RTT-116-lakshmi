package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.Customer;
import org.example.database.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public Customer update(Customer customer) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        try {
            session.merge(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return customer;
       // session.close();

    }

    public Customer create(Customer customer) {
        Session session = factory.openSession();
        // starting a database transaction
        session.getTransaction().begin();

        // in an older style of hibernate we need to use the persist function when we want to create a new record
        session.persist(customer);
        session.getTransaction().commit();
        //session.close();
        return customer;
    }


    public void delete(Customer customer) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.delete(customer);
        session.getTransaction().commit();
        session.close();

    }

    public Customer findById(Integer id) {

        String hqlQuery = "Select c from Customer c where c.id = :customerid";

        Session session = factory.openSession();

        TypedQuery<Customer> query = session.createQuery(hqlQuery, Customer.class);

        query.setParameter("customerid", id);
        try {
            Customer result = query.getSingleResult();
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            // have to close this session at the end which tells hibernate to give back it to the pool
            session.close();
        }


    }

    public List<Customer> findByName(String firstName, String lastName) {

        String hqlQuery = "SELECT c FROM Customer c WHERE c.contactFirstname = :firstName AND c.contactLastname = :lastName";
        Session session = factory.openSession();
        TypedQuery<Customer> query = session.createQuery(hqlQuery, Customer.class);

        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);

        try {
            List<Customer> result = query.getResultList();
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return new ArrayList<Customer>();
        } finally {
            session.close();
        }
    }
    public List<Customer> findCustomerWithName(String name) {
        Session session = factory.openSession();

        String hqlName = "SELECT c FROM Customer c WHERE c.contactFirstname = :cName " +
                "                                   OR c.customername = :cName" +
                "                                   OR c.contactLastname = :cName" +
                "                                   ORDER BY c.contactFirstname";

        TypedQuery<Customer> query = session.createQuery(hqlName, Customer.class);
        query.setParameter("cName", name);

        try{
            List<Customer> resultNameList = query.getResultList();
            return resultNameList;
        }catch(Exception e) {
            return new ArrayList<>();

        }finally {
            session.close();
        }

    }


    public List<Customer> search(String name) {

        String hqlQuery = "Select c from Customer c where c.customername LIKE concat('%',:name, '%') order by c.city";

        Session session = factory.openSession();

        TypedQuery<Customer> query = session.createQuery(hqlQuery, Customer.class);

        query.setParameter("name", name);

        try {
            List<Customer> result = query.getResultList();
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }


    }

}
