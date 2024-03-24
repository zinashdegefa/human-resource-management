package org.zinashdegefa.humanresourcemanagement.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zinashdegefa.humanresourcemanagement.models.Department;
import org.zinashdegefa.humanresourcemanagement.models.Employee;
import org.zinashdegefa.humanresourcemanagement.models.UserModel;
import org.zinashdegefa.humanresourcemanagement.repositories.DepartmentRepository;
import org.zinashdegefa.humanresourcemanagement.services.DepartmentService;

import java.util.List;
import java.util.Optional;

// Department Service Implementation class

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository)
    {
        this.departmentRepository = departmentRepository;
    }
    @Override
    public Department saveDepartment(Department department) {

        department.setDepartmentName(department.getDepartmentName().trim()); //Trim the name before saving

        Department savedDepartment = departmentRepository.save(department);

        return savedDepartment;
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();

        return departments;

    }

    @Override
    @Transactional
    public Department getDepartmentById(int departmentId) {
        Optional<Department> getDepartmentById = departmentRepository.findById((long) departmentId);
        if (getDepartmentById.isPresent()) {
            System.out.println("The Id of the department is " + getDepartmentById.get().getId());
            System.out.println("The Name is " + getDepartmentById.get().getDepartmentName());

            return getDepartmentById.get();
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteDepartment(int departmentId) {
        departmentRepository.deleteById((long) departmentId);
        System.out.println("The department with id number "  + departmentId + " is deleted!");
    }

    @Override
    @Transactional
    public void updateDepartment(Department department) {

        departmentRepository.save(department);
    }

    public Department getDepartmentByName(String name){

        return departmentRepository.findByDepartmentName(name.trim());

    }
}
