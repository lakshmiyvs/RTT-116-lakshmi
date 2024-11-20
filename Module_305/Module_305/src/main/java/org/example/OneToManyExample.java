package org.example;

import org.example.database.dao.CustomerDAO;
import org.example.database.dao.EmployeeDAO;
import org.example.database.dao.OrderDAO;
import org.example.database.dao.ProductDAO;
import org.example.database.entity.Customer;
import org.example.database.entity.Employee;
import org.example.database.entity.Order;

import java.util.List;

public class OneToManyExample {

    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        OrderDAO orderDAO = new OrderDAO();
    //    orderDAO.findByProductId(10100);
        ProductDAO productDAO = new ProductDAO();
        List<Order> orderList = productDAO.findByProductId(27);
        productDAO.addProduct(10100);

            for(Order o : orderList) {
            System.out.println(o);
        }


        Employee e = employeeDAO.findById(1501);

        System.out.println(e);

        for (Customer c : e.getCustomers()) {
            System.out.println(c);

            System.out.println(c.getEmployee());
        }

        Customer newCustomer = new Customer();

        newCustomer.setCustomername("New Customer");
        newCustomer.setContactFirstname("Eric");
        newCustomer.setContactLastname("Eric");
        newCustomer.setPhone("555556661");
        newCustomer.setAddressLine1("456");
        newCustomer.setAddressLine2("8766");
        newCustomer.setCity("City");
        newCustomer.setState("Florida");
        newCustomer.setCountry("USA");
        newCustomer.setPostalCode("023456");
        newCustomer.setCreditLimit(153.23);
        newCustomer.setEmployee(e);

        //customerDAO.createCustomer(newCustomer);
        // this is the best way to do this but wanted to show other hibernate features
        // then we can add the new customer to the list of existing customers for this employee
        e.getCustomers().add(newCustomer);

        // THEN !!!!!  we save the employee!!!!!!!!!!!
        employeeDAO.update(e);



    }
}
