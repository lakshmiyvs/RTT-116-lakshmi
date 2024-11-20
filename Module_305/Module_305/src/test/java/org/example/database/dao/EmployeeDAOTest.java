package org.example.database.dao;

import org.example.database.entity.Customer;
import org.example.database.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class EmployeeDAOTest {

    private EmployeeDAO employeeDAO;

    @BeforeEach
    public void setUp() {
        employeeDAO = new EmployeeDAO();
    }

    @Test
    public void testFindById() {
        // Assuming employee with ID 1 exists in the database
        int employeeId = 1;
        Employee employee = employeeDAO.findById(employeeId);
        assertNotNull(employee, "Employee should exist in the database");
        assertEquals(employeeId, employee.getId(), "Employee ID should match");
    }

//    @Test
//    public void testFindByFirstName() {
//        String firstName = "Leslie";
//
//        // Assuming there are 2 employees with the name "Leslie" in the database
//        int expectedCount = 2;
//
//        List<Employee> employees = employeeDAO.findByFirstName(firstName);
//        assertNotNull(employees, "Result list should not be null");
//        assertEquals(expectedCount, employees.size(), "Number of employees found should match the expected count");
//    }

    @Test
    public void testCreateEmployee() {
        Employee newEmployee = new Employee();
        newEmployee.setFirstname("John");
        newEmployee.setLastname("Doe");
        newEmployee.setEmail("johndoe@example.com");


        employeeDAO.update(newEmployee);

        Employee savedEmployee = employeeDAO.findById(newEmployee.getId());
        assertNotNull(savedEmployee, "Saved employee should exist in the database");
        assertEquals("John", savedEmployee.getFirstname(), "First name should match");
        assertEquals("Doe", savedEmployee.getLastname(), "Last name should match");
        assertEquals("johndoe@example.com", savedEmployee.getEmail(), "Email should match");

    }

    @Test
    public void testUpdateEmployee() {
        // Given
        Employee existingEmployee = employeeDAO.findById(1);
        assertNotNull(existingEmployee, "Employee should exist in the database");

        existingEmployee.setLastname("Smith");
        employeeDAO.update(existingEmployee);

        // When
        Employee updatedEmployee = employeeDAO.findById(1);

        // Then
        assertEquals("Smith", updatedEmployee.getLastname(), "Last name should be updated");

    }

    @Test
    public void testDeleteEmployee() {
        // Create a new employee for deletion
        Employee employeeToDelete = new Employee();
        employeeToDelete.setFirstname("DeleteMe");
        employeeToDelete.setLastname("Test");
        employeeToDelete.setEmail("delete@example.com");
        employeeDAO.update(employeeToDelete);

        // Delete the employee
        employeeDAO.delete(employeeToDelete);

        // Assert the employee is deleted
        Employee deletedEmployee = employeeDAO.findById(employeeToDelete.getId());
        assertNull(deletedEmployee, "Employee should be null after deletion");
    }
}
