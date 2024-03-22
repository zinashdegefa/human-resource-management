package org.zinashdegefa.humanresourcemanagement.services;

import org.zinashdegefa.humanresourcemanagement.models.UserModel;

// User Service Interface
public interface UserService {

    void saveUser(UserModel user);
    UserModel getUserByEmail(String email);
}
