package org.zinashdegefa.humanresourcemanagement.services.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.zinashdegefa.humanresourcemanagement.models.*;
import org.zinashdegefa.humanresourcemanagement.repositories.DepartmentRepository;
import org.zinashdegefa.humanresourcemanagement.repositories.EmployeeRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeServiceImplTest {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;
    @Test
    void getAllEmployees() {

        Mockito.when(employeeRepository.findAll()).thenReturn(employeeList());
        List<Employee> empList = employeeService.getAllEmployees();
        System.out.println("List of employees: " + empList);
        Assertions.assertNotNull(empList);
        assertEquals("TestFirstName", empList.get(0).getFirstName());
    }

    private List<Employee> employeeList() {

    Employee employee = Employee.builder()
            .firstName("TestFirstName")
            .lastName("TestLastName")
            .role(Role.builder().roleName("TestRoleName").build())
            .level(Level.builder().levelName("TestLevelName").build())
            .department(Department.builder().departmentName("TestDepartmentName").build())
            .manager(Manager.builder().firstName("testManFirstName").lastName("TestManLastName").department(Department.builder().departmentName("departmentName").build()).build())
            .build();

    return List.of(employee);
    }
}