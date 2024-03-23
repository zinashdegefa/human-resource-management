package org.zinashdegefa.humanresourcemanagement.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

//  Employee Model Class

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Builder
@Table(name = "employee")
public class Employee {

    @Column(name = "employee_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "First Name is required")
    @Column(nullable = false)
    private String firstName;

    @NotEmpty(message = "Last Name is required")
    @Column(nullable = false)
    private String lastName;

    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "level_id")
    private Level level;

    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "department_id")
    private Department department;


}
