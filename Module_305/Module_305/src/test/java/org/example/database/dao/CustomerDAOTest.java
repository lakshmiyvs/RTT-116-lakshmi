package org.example.database.dao;

import org.example.database.entity.Customer;
import org.example.database.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class CustomerDAOTest {

    private CustomerDAO customerDAO = new CustomerDAO();
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    @Test
    public void findByIdTest() {
        // given is the setup
        int givencustomerId = 125;

        // when is actually going to execute the code
        Customer actual = customerDAO.findById(givencustomerId);

        // then
        Assertions.assertEquals("Havel & Zbyszek Co", actual.getCustomername());
        Assertions.assertEquals(givencustomerId, actual.getId());
        Assertions.assertEquals(0.00, actual.getCreditLimit());

    }

    @Test


    public void createCustomer() {

        //given
        Customer given = new Customer();

        given.setCustomername("New Customer");
        given.setContactFirstname("Eric");
        given.setContactLastname("Eric");
        given.setPhone("5555551212");
        given.setAddressLine1("5555551212");
        given.setAddressLine1("222222");
        given.setCity("city");
        given.setState("asdfasdf");
        given.setPostalCode("023432");
        given.setCountry("USA");
        given.setCreditLimit(234.33);

        // we are not testing the employee so it is okay to just query one from the database and set it
        Employee employee = employeeDAO.findById(1216);
        given.setEmployee(employee);

        // when
        // customerDAO.create(given);
        Assertions.assertNull(given.getId());
        Customer actual = customerDAO.create(given);

        // then
        Assertions.assertNotNull(actual.getId());
        Assertions.assertNull(actual.getSalesRepEmployeeId());

        Assertions.assertEquals(given.getContactFirstname(), actual.getContactFirstname());
        Assertions.assertEquals(given.getContactLastname(), actual.getContactLastname());

        //create an additional assertion to check the employee id is correct
        Assertions.assertEquals(employee.getId(), actual.getEmployee().getId());

    }

    @ParameterizedTest
    @CsvSource({
            "103, Atelier graphique",
            "112, Signal Gift Stores",
            "114, 'Australian Collectors, Co.'"
    })
    public void findByIdTest(int customerId, String customerName) {
        // this is not a very good test .. just doing it to show how this works
        // given
        // when
        Customer actual = customerDAO.findById(customerId);

        // then
        Assertions.assertEquals(customerName, actual.getCustomername());


    }
}