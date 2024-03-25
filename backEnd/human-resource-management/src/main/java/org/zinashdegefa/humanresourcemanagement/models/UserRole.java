package org.zinashdegefa.humanresourcemanagement.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

//  UserRole Model Class

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = true)
    String name;
    @ManyToMany(mappedBy = "userRoles")
    List<UserModel> users = new ArrayList<>();

    public UserRole(Long id, String name, List<UserModel> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }
}