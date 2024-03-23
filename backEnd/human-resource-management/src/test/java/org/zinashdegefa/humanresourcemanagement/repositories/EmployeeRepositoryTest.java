package org.zinashdegefa.humanresourcemanagement.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zinashdegefa.humanresourcemanagement.models.Department;
import org.zinashdegefa.humanresourcemanagement.models.Employee;
import org.zinashdegefa.humanresourcemanagement.models.Level;
import org.zinashdegefa.humanresourcemanagement.models.Role;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void saveemployee() {
        Employee employee = Employee
                .builder()
                .firstName("TestFirstName")
                .lastName("TestLastName")
                .department(Department.builder().departmentName("TestDepartment").build())
                .level(Level.builder().levelName("TestLevel").build())
                .role(Role.builder().roleName("TestRole").build())
                .build();


        employeeRepository.save(employee);

        System.out.println("Saved employee: " + employee);
        Assertions.assertTrue(employee.getId() > 0);
    }

    @Test
    void getAllemployee() {
        Employee employee = Employee
                .builder()
                .firstName("TestFirstName")
                .lastName("TestLastName")
                .department(Department.builder().departmentName("TestDepartment1").build())
                .level(Level.builder().levelName("TestLevel1").build())
                .role(Role.builder().roleName("TestRole1").build())
                .build();


        employeeRepository.save(employee);
        List<Employee> employeesList = employeeRepository.findAll();
        Assertions.assertNotNull(employeesList);
    }


    @Test
    void updateEmployee() {

        Employee employee = Employee
                .builder()
                .firstName("TestFirstName")
                .lastName("TestLastName")
                .department(Department.builder().departmentName("TestDepartment2").build())
                .level(Level.builder().levelName("TestLevel2").build())
                .role(Role.builder().roleName("TestRole2").build())
                .build();
        employeeRepository.save(employee);

        Employee employeeFromDb = employeeRepository.findById((long) employee.getId()).orElse(null);
        assertNotNull(employeeFromDb);
        employeeFromDb.setFirstName("TestFirstNameUpdated");

        System.out.println("Employee updated " + employeeFromDb);
        employeeRepository.save(employeeFromDb);

        Employee empUpdated = employeeRepository.findById((long)employeeFromDb.getId()).orElse(null);

        assertNotNull(empUpdated);
        assertEquals(empUpdated.getFirstName(), "TestFirstNameUpdated");

    }

    @Test
    void deleteemployee() {
        Employee employee = Employee
                .builder()
                .firstName("TestFirstName")
                .lastName("TestLastName")
                .department(Department.builder().departmentName("TestDepartment3").build())
                .level(Level.builder().levelName("TestLevel3").build())
                .role(Role.builder().roleName("TestRole3").build())
                .build();
        employeeRepository.save(employee);

        Employee employeeFromDb = employeeRepository.findById((long) employee.getId()).orElse(null);
        assertNotNull(employeeFromDb);

        employeeRepository.delete(employeeFromDb);

        Employee employeeAfterDeleted = employeeRepository.findById((long) employeeFromDb.getId()).orElse(null);

        System.out.println("Employee deleted " + employeeAfterDeleted);
        assertNull(employeeAfterDeleted);

    }

}