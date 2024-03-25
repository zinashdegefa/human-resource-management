package org.zinashdegefa.humanresourcemanagement.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

//  UserModel Model Class
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    @NotEmpty(message = "First Name is required")
    String firstName;

    @Column(nullable = false)
    @NotEmpty(message = "Last Name is required")
    String lastName;

    @NotEmpty(message = "Email is required")
    @Email
    String email;

    @NotEmpty(message = "Password is required")
    @Column(nullable = false, unique = true)
    String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_role_id ", referencedColumnName = "id"
            )})
    public List<UserRole> userRoles = new ArrayList<>();

    public UserModel(Long id, String firstName, String lastName, String email, String password, List<UserRole> userRoles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userRoles = userRoles;
    }

}
