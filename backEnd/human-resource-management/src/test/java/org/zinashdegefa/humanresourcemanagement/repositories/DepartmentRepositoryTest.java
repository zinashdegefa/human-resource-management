package org.zinashdegefa.humanresourcemanagement.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zinashdegefa.humanresourcemanagement.models.Department;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void saveDepartment() {
        Department department = Department
                .builder()
                .departmentName("TestDepartment")
                .build();


        departmentRepository.save(department);

        System.out.println("Saved department: " + department);
        Assertions.assertTrue(department.getId() > 0);
    }

    @Test
    void getAllDepartment() {
        Department department = Department
                .builder()
                .departmentName("TestDepartment1")
                .build();
        departmentRepository.save(department);
       List<Department> departmentList = departmentRepository.findAll();
        Assertions.assertNotNull(departmentList);
    }

    @Test
    void findByDepartmentName() {
        Department department = Department
                .builder()
                .departmentName("TestDepartment2")
                .build();
        departmentRepository.save(department);

      Department dep = departmentRepository.findByDepartmentName("TestDepartment2");
        Assertions.assertEquals(dep.getDepartmentName(), "TestDepartment2");

    }

    @Test
    void updateDepartment() {
        Department department = Department
                .builder()
                .departmentName("TestDepartment3")
                .build();
        departmentRepository.save(department);
        Department departmentFromDb = departmentRepository.findByDepartmentName("TestDepartment3");
        departmentFromDb.setDepartmentName("TestDepartment3Updated");

        System.out.println("Department updated " + departmentFromDb);
        departmentRepository.save(departmentFromDb);

        Department depUpdated = departmentRepository.findById((long)departmentFromDb.getId()).orElse(null);

        assertNotNull(depUpdated);
        assertEquals(depUpdated.getDepartmentName(), "TestDepartment3Updated");

    }

    @Test
    void deleteDepartment() {
        Department department = Department
                .builder()
                .departmentName("TestDepartment5")
                .build();
        departmentRepository.save(department);

        Department departmentFromDb = departmentRepository.findByDepartmentName("TestDepartment5");

        departmentRepository.delete(departmentFromDb);

        Department departmentAfterDeleted = departmentRepository.findByDepartmentName("TestDepartment5");

        System.out.println("Department deleted " + departmentAfterDeleted);
       assertNull(departmentAfterDeleted);

    }

}