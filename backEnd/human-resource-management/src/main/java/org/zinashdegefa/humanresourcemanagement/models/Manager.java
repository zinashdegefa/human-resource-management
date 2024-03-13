package org.zinashdegefa.humanresourcemanagement.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "manager")
public class Manager {

    @Column(name = "manager_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int managerId;

    private String firstName;

    private String lastName;

    private String department;
}
