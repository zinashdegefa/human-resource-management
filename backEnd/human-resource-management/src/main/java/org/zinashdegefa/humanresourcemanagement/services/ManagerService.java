package org.zinashdegefa.humanresourcemanagement.services;


import org.zinashdegefa.humanresourcemanagement.models.Manager;

import java.util.List;

public interface ManagerService {

    void addManager(Manager manager);
    List<Manager> getAllManagers();
    void deleteManager(int managerId);
}
