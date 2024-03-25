package org.zinashdegefa.humanresourcemanagement.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zinashdegefa.humanresourcemanagement.models.Employee;
import org.zinashdegefa.humanresourcemanagement.models.Level;
import org.zinashdegefa.humanresourcemanagement.models.Manager;
import org.zinashdegefa.humanresourcemanagement.repositories.ManagerRepository;
import org.zinashdegefa.humanresourcemanagement.services.ManagerService;

import java.security.interfaces.ECKey;
import java.util.List;
import java.util.Optional;

// Manager Service Implementation class

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerServiceImpl(ManagerRepository managerRepository)
    {
        this.managerRepository = managerRepository;
    }

    @Override
    public void saveManager(Manager manager) {
            managerRepository.save(manager);
    }

    @Override
    public List<Manager> getAllManagers() {
        List<Manager> managers = managerRepository.findAll();

        return managers;

    }

    @Override
    @Transactional
    public Manager getManagerById(int managerId) {
        Optional<Manager> getManagerById = managerRepository.findById((long) managerId);
        if (getManagerById.isPresent()) {
            System.out.println("The Id of the manager is " + getManagerById.get().getId());
            return getManagerById.get();
        }
        return null;
    }

    @Override
    @Transactional
    public Manager getManagerByDepartmentId(int departmentId) {
        Optional<Manager> getManagerById = managerRepository.findByDepartmentId(departmentId);
        if (getManagerById.isPresent()) {
            System.out.println("The Id of the manager is " + getManagerById.get().getId());
            return getManagerById.get();
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteManager(int managerId) {
        managerRepository.deleteById((long) managerId);
        System.out.println("The manager with id number "  + managerId + " is deleted!");
    }

    @Override
    @Transactional
    public void updateManager(Manager manager) {
        managerRepository.save(manager);
    }
}
