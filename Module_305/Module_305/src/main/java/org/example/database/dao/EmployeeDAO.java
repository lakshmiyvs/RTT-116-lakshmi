package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.Customer;
import org.example.database.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void update(Employee employee) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        try {
            session.merge(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.close();

    }

    public void create(Employee employee) {
        Session session = factory.openSession();
        // starting a database transaction
        session.getTransaction().begin();

        // in an older style of hibernate we need to use the persist function when we want to create a new record
        session.persist(employee);
        session.getTransaction().commit();
        session.close();
    }


    public void delete(Employee employee) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.delete(employee);
        session.getTransaction().commit();
        session.close();

    }

    public Employee findById(int employeeId) {

        String hqlQuery = "Select e from Employee e where id = :employeeId";

        Session session = factory.openSession();

        TypedQuery<Employee> query = session.createQuery(hqlQuery, Employee.class);

        query.setParameter("employeeId", employeeId);
        try {
            Employee employee = query.getSingleResult();
            return employee;
        } catch (Exception e) {
            return null;
        } finally {
            // have to close this session at the end which tells hibernate to give back it to the pool
            session.close();
        }


    }


    public List<Customer> findByName(String firstName, String lastName) {

        String hqlQuery = "SELECT e FROM Employee e WHERE e.firstname = :firstName AND e.lastname = :lastName";
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

}










