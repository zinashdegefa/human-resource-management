package org.zinashdegefa.humanresourcemanagement.services.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.zinashdegefa.humanresourcemanagement.models.UserModel;
import org.zinashdegefa.humanresourcemanagement.models.UserRole;
import org.zinashdegefa.humanresourcemanagement.repositories.UserRepository;
import org.zinashdegefa.humanresourcemanagement.repositories.UserRoleRepository;
import org.zinashdegefa.humanresourcemanagement.services.UserService;

import java.util.Arrays;

// User Service Implementation class

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository,
                           PasswordEncoder passwordEncoder) {
        super();
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserModel user) {
        UserModel userModel = new UserModel();

        userModel.setFirstName(user.getFirstName());
        userModel.setLastName(user.getLastName());
        userModel.setEmail(user.getEmail());

        // Encrypt the password using Spring Security
        userModel.setPassword(passwordEncoder.encode(user.getPassword()));
        UserRole userRole = userRoleRepository.findByName("ROLE_ADMIN");
        if (userRole == null) {
            userRole = checkRoleExist();
        }
        userModel.setUserRoles(Arrays.asList(userRole));
        userRepository.save(userModel);
    }

    private UserRole checkRoleExist() {
        UserRole role = new UserRole();
        role.setName("ROLE_ADMIN");
        return userRoleRepository.save(role);
    }

    public UserModel getUserByEmail(String email) {

        return userRepository.findByEmail(email);

    }

}
