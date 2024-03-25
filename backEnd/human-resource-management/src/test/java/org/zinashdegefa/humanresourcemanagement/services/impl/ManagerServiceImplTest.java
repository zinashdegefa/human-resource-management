package org.zinashdegefa.humanresourcemanagement.services.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.zinashdegefa.humanresourcemanagement.models.Department;
import org.zinashdegefa.humanresourcemanagement.models.Manager;
import org.zinashdegefa.humanresourcemanagement.repositories.ManagerRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ManagerServiceImplTest {

    @Autowired
    private ManagerServiceImpl managerService;

    @MockBean
    private ManagerRepository managerRepository;
    @Test
    void getManagerByDepartmentId() {

        Mockito.when(managerRepository.findByDepartmentId(1)).thenReturn(Optional.of(getManagerObject()));
        Manager manager = managerService.getManagerByDepartmentId(1);
        System.out.println("List of Managers: " + manager);
        Assertions.assertNotNull(manager);
        assertEquals("TestManFirstName", manager.getFirstName());
    }

    private Manager getManagerObject() {
        return Manager.builder().firstName("TestManFirstName")
                .lastName("ManLastName")
                .department(Department.builder().departmentName("DepName").build())
                .build();
    }
}