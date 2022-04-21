package com.germafica.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * This class represents a character.
 * Please keep your @Entity class separated from it's
 * JSON representation. Using Jackson annotations here
 * it's a bad practice.
 */
// @ToString // don't use it
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor // JPA requires that this constructor be defined as public or protected
@Entity(name = "Character")
@Table(name = "character")
public class Character {
    // == fields ==
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false, updatable = true)
    @Size(max = 20)
    @NonNull
    private String name;

    @Column(unique = true, nullable = false, updatable = true)
    @NonNull
    private int level;

    @Column(unique = true, nullable = false, updatable = true)
    @NonNull
    private int health;

    @Column(unique = true, nullable = false, updatable = true)
    @NonNull
    private int experience;

    // == associations ==

    // == owns relationship ==
}
