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
    private int id;

    private String firstName;

    private String lastName;
    @OneToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
