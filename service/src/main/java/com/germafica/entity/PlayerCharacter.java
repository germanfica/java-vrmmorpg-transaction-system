package com.germafica.entity;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a player character.
 * Please keep your @Entity class separated from it's
 * JSON representation. Using Jackson annotations here
 * it's a bad practice.
 */
// @ToString // don't use it
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor // JPA requires that this constructor be defined as public or protected
@Entity(name = "PlayerCharacter")
@Table(name = "player_character")
public class PlayerCharacter {
    // == fields ==
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false, updatable = true)
    @Size(max = 20)
    @NonNull
    private String name;

    @Column(nullable = false, updatable = true)
    @NonNull
    private int level;

    @Column(nullable = false, updatable = true)
    @NonNull
    private int health;

    @Column(nullable = false, updatable = true)
    @NonNull
    private int experience;

    // == associations ==

    // == belongs relationship ==
    @Getter(value = AccessLevel.NONE)
    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    // == owns relationship ==
    @Getter(value = AccessLevel.NONE)
    @OneToMany(mappedBy = "playerCharacter", cascade = CascadeType.ALL)
    @LazyCollection( LazyCollectionOption.EXTRA )
    private Set<Item> items = new HashSet<>();
}
