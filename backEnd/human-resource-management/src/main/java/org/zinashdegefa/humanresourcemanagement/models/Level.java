package org.zinashdegefa.humanresourcemanagement.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

//  Level Model Class

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "level")
public class Level {
    @Column(name = "level_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Level Name is required")
    @Column(nullable = false, unique=true)
    private String levelName;


}
