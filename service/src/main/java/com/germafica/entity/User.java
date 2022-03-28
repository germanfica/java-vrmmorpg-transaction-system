package com.germafica.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * This class represents a user.
 * Please keep your @Entity class separated from it's
 * JSON representation. Using Jackson annotations here
 * it's a bad practice.
 */
// @ToString // don't use it
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor // JPA requires that this constructor be defined as public or protected
@Entity(name = "User")
@Table(name = "user")
public class User {
    // == fields ==
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false, updatable = false)
    @Size(max = 20)
    @NonNull
    private String username;

    @Column(nullable = false, columnDefinition = "VARCHAR(45)")
    @Size(max = 45)
    @NonNull
    private String firstName;

    @Column(nullable = false, columnDefinition = "VARCHAR(45)")
    @Size(max = 45)
    @NonNull
    private String lastName;

    @Column(nullable = false, columnDefinition = "VARCHAR(45)")
    @Size(max = 45)
    @NonNull
    private String email;

    @Column(nullable = false, columnDefinition = "VARCHAR(120)")
    @Size(max = 120)
    @NonNull
    private String password;

    // == associations ==

    // == owns relationship ==
    @Getter(value = AccessLevel.NONE)
    @ManyToOne(fetch = FetchType.LAZY)
    private Inventory inventory;
}
