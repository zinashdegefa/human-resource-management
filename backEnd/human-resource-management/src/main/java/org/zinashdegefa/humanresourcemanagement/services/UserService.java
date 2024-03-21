package org.zinashdegefa.humanresourcemanagement.services;

import org.zinashdegefa.humanresourcemanagement.models.UserModel;

public interface UserService {

    void saveUser(UserModel user);
    UserModel getUserByEmail(String email);
}
