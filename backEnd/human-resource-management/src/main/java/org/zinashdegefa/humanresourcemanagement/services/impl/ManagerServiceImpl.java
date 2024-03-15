package org.zinashdegefa.humanresourcemanagement.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zinashdegefa.humanresourcemanagement.models.Employee;
import org.zinashdegefa.humanresourcemanagement.models.Manager;
import org.zinashdegefa.humanresourcemanagement.repositories.ManagerRepository;
import org.zinashdegefa.humanresourcemanagement.services.ManagerService;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerServiceImpl(ManagerRepository managerRepository)
    {
        this.managerRepository = managerRepository;
    }

    @Override
    public void addManager(Manager manager) {

        managerRepository.save(manager);
    }

    @Override
    public List<Manager> getAllManagers() {
        List<Manager> managers = managerRepository.findAll();

        return managers;

    }

    @Override
    @Transactional
    public void deleteManager(int managerId) {
        managerRepository.deleteById((long) managerId);
        System.out.println("The manager with id number "  + managerId + " is deleted!");
    }
}
