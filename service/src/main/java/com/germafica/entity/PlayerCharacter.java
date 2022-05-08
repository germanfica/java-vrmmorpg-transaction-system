package com.germafica.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
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
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

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

    @Column(nullable = false, updatable = true)
    @NonNull
    private float x;

    @Column(nullable = false, updatable = true)
    @NonNull
    private float y;

    @Column(nullable = false, updatable = true)
    @NonNull
    private float z;

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

    // == type-specific ==
    public PlayerCharacter update(PlayerCharacter playerCharacter) {
        if(playerCharacter.getName()!=null) this.setName(playerCharacter.getName());
        if(playerCharacter.getLevel()!=-0) this.setLevel(playerCharacter.getLevel());
        if(playerCharacter.getHealth()!=-0) this.setHealth(playerCharacter.getHealth());
        if(playerCharacter.getExperience()!=0) this.setExperience(playerCharacter.getExperience());
        if(playerCharacter.getX()!=0) this.setX(playerCharacter.getX());
        if(playerCharacter.getY()!=0) this.setY(playerCharacter.getY());
        if(playerCharacter.getZ()!=0) this.setZ(playerCharacter.getZ());

        return this;
    }
}
