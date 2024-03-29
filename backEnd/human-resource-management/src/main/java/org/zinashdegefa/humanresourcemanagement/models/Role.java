package org.zinashdegefa.humanresourcemanagement.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

//  Role Model Class
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "employee_role")
public class Role {

    @Column(name = "role_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Role Name is required")
    @Column(nullable = false, unique = true)
    private String roleName;
}
