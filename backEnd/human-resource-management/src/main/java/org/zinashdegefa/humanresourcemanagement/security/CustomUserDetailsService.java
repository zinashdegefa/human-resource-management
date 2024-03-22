package org.zinashdegefa.humanresourcemanagement.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zinashdegefa.humanresourcemanagement.models.UserModel;
import org.zinashdegefa.humanresourcemanagement.repositories.UserRepository;

import java.util.stream.Collectors;

// Custom User Details Service Class to validate email and password

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;
    public CustomUserDetailsService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

       UserModel userModel = userRepository.findByEmail(usernameOrEmail);
        if(userModel != null) {
            return new org.springframework.security.core.userdetails.User(userModel.getEmail(),
                    userModel.getPassword(),
                    userModel.getUserRoles().stream()
                            .map((role) -> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toList()));
        }else {
            throw new UsernameNotFoundException("Invalid email or password");
        }
    }
}
