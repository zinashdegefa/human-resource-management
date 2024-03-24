package org.zinashdegefa.humanresourcemanagement.services.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.zinashdegefa.humanresourcemanagement.models.Department;
import org.zinashdegefa.humanresourcemanagement.repositories.DepartmentRepository;
import org.zinashdegefa.humanresourcemanagement.services.DepartmentService;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class DepartmentServiceImplTest {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @Test
    void saveDepartment() {

        Department department = Department
                .builder()
                .departmentName("TestDepartment")
                .build();

        Mockito.when(departmentRepository.save(department)).thenReturn(department);
        Department dep = departmentService.saveDepartment(department);

        System.out.println("Saved department: " + department);
        Assertions.assertEquals(department, dep);
    }
}