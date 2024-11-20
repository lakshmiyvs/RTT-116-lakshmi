package org.example.database.dao;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.example.database.entity.Customer;
import org.example.database.entity.Order;
import org.example.database.entity.OrderDetail;
import org.example.database.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    // at the class member level make your session factory ... for all DAO
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void update(Product product) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        try {
            session.merge(product);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.close();

    }

    public void create(Product product) {
        Session session = factory.openSession();
        // starting a database transaction
        session.getTransaction().begin();

        // in an older style of hibernate we need to use the persist function when we want to create a new record
        session.persist(product);
        session.getTransaction().commit();
        session.close();
    }


    public void delete(Product product) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.delete(product);
        session.getTransaction().commit();
        session.close();

    }

    public void deleteById(int id) {
        Session session = factory.openSession();
        session.beginTransaction();
        Product product = (Product) session.get(Product.class, id);
        session.delete(product);
        session.getTransaction().commit();
        session.close();
    }

    public List<Product> findByOrderId(int orderId) {
        Session session = factory.openSession();
//        String hqlQuery = "SELECT p FROM Product p, OrderDetail od WHERE p.id = od.productId AND od.orderId = :orderId";
        String hqlQuery = "SELECT p FROM Product p WHERE p.id IN (SELECT od.productId FROM OrderDetail od WHERE od.orderId = :orderId)";
        TypedQuery<Product> query = session.createQuery(hqlQuery, Product.class);
        query.setParameter("orderId", orderId);
        try {
            List<Product> result = query.getResultList();
            return result;
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }


    // below here is our queries
    //** This query gets created in every single DAO make**
    public Product findById(Integer id) {
        // Hibernate queries must use the java names from the entities
        // this is HQL
        String hqlQuery = "Select p from Product p where p.id = :productid";
        // this is what is called native SQL- the native query only included here to show
        //String sql = "select * from product where id = ?";

        Session session = factory.openSession();

        TypedQuery<Product> query = session.createQuery(hqlQuery, Product.class);

        query.setParameter("productid", id);
        //query.setParameter("xcustomerName", customer);
        // we know this is a primary key so this query will return 0 records or 1 record
        // if the product was not found in the database we want to return null from our function
        // otherewise we want to return our product
        // hibernate will run the query and create a new product entity and fill it up with the data for us
        try {
            Product result = query.getSingleResult();
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            // have to close this session at the end which tells hibernate to give back it to the pool
            session.close();
        }


    }

    /**
     * Return a list of products that match the name
     *
     * A function that retuns a list will always return a list even if the query returns 0 results
     */

    public List<Product> search(String name) {

        String hqlQuery = "Select p from Product p where p.productName LIKE concat('%',:name, '%') order by p.buyPrice";

        Session session = factory.openSession();

        TypedQuery<Product> query = session.createQuery(hqlQuery, Product.class);

        query.setParameter("name", name);

        try {
            List<Product> result = query.getResultList();
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }




    }
    public List<Order> findByProductId(Integer id) {

        String hqlQuery = "select o from OrderDetail od join Order o on o.id = od.orderId" +
                "        where od.productId = :productId";
        ;
        Session session = factory.openSession();

        TypedQuery<Order> query = session.createQuery(hqlQuery, Order.class);

        query.setParameter("productId", id);

        try {
            List<Order> result = query.getResultList();
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            // have to close this session at the end which tells hibernate to give back it to the pool
            session.close();
        }


    }

    public void addProduct(Integer id) {

        Session session = factory.openSession();
        try {
        Product product = new Product();
        //product.setId(555);
        product.setProductDescription("Test Product");
        product.setProductName("Test Product30");
        product.setProductCode("101");
        product.setProductScale("Test1");
        product.setProductVendor("Test Vendor");
        product.setQuantityInStock(105);
        product.setBuyPrice(100.00);
        product.setMsrp(106.00);
        product.setProductlineId(1);
       // create(product);
        session.getTransaction().begin();

            // in an older style of hibernate we need to use the persist function when we want to create a new record
        session.persist(product);

        session.getTransaction().commit();




        String hqlQuery = "select id from Product where productName = :name";
        TypedQuery<Integer> query = session.createQuery(hqlQuery, Integer.class);
        query.setParameter("name", "Test Product30");
        int result = query.getSingleResult();
        OrderDetail orderdetail = new OrderDetail();
        orderdetail.setOrderId(id);
        orderdetail.setProductId(result);
        //orderdetail.setId(555);
        orderdetail.setQuantityOrdered(100);
        orderdetail.setOrderLineNumber(105);
        orderdetail.setPriceEach(106.00);
        session.getTransaction().begin();

            // in an older style of hibernate we need to use the persist function when we want to create a new record

        session.persist(orderdetail);
        session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // have to close this session at the end which tells hibernate to give back it to the pool
            session.close();
        }


    }
}

