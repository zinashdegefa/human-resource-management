package org.zinashdegefa.humanresourcemanagement.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

//  Manager Model Class

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "manager")
public class Manager {

    @Column(name = "manager_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "First Name is required")
    @Column(nullable = false)
    private String firstName;

    @NotEmpty(message = "Last Name is required")
    @Column(nullable = false)
    private String lastName;

    @OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "department_id")
    private Department department;
}
