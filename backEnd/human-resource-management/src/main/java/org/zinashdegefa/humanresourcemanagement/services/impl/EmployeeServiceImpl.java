package org.zinashdegefa.humanresourcemanagement.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zinashdegefa.humanresourcemanagement.models.Department;
import org.zinashdegefa.humanresourcemanagement.models.Employee;
import org.zinashdegefa.humanresourcemanagement.repositories.EmployeeRepository;
import org.zinashdegefa.humanresourcemanagement.services.EmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// Employee Service Implementation class

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository)
    {

        this.employeeRepository = employeeRepository;
    }

    @Override
    public void saveEmployee(Employee employee) {

        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees;

    }

    @Override
    @Transactional
    public Employee getEmployeeById(int employeeId) {
        Optional<Employee> getEmployeeById = employeeRepository.findById((long) employeeId);
        if (getEmployeeById.isPresent()) {
            System.out.println("The Id of the employee is " + getEmployeeById.get().getId());
            System.out.println("The Name is " + getEmployeeById.get().getFirstName());

            return getEmployeeById.get();
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteById((long) employeeId);
        System.out.println("The employee with id number "  + employeeId + " is deleted!");
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {

        employeeRepository.save(employee);
    }

}
