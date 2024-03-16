package org.zinashdegefa.humanresourcemanagement.models;

import jakarta.persistence.*;
import lombok.*;

import java.lang.annotation.Documented;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "level")
public class Level {
    @Column(name = "level_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String levelName;


}
