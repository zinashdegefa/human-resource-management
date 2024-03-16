package org.zinashdegefa.humanresourcemanagement.services;


import org.zinashdegefa.humanresourcemanagement.models.Manager;

import java.util.List;

public interface ManagerService {

    void saveManager(Manager manager);
    List<Manager> getAllManagers();
    void deleteManager(int managerId);
    public void updateManager(Manager manager);
    Manager getManagerById(int managerId);
}
