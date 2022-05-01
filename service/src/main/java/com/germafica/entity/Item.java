package com.germafica.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * This class represents an item.
 * Please keep your @Entity class separated from it's
 * JSON representation. Using Jackson annotations here
 * it's a bad practice.
 */
// @ToString // don't use it
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor // JPA requires that this constructor be defined as public or protected
@Entity(name = "Item")
@Table(name = "item")
public class Item {
    // == fields ==
    @Column(nullable = false)
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    @NonNull
    private String name;

    @NonNull
    private int level;

    @NonNull
    private int durability;

    // == associations ==

    // == owns relationship ==
    @Getter(value = AccessLevel.NONE)
    @ManyToOne(fetch = FetchType.LAZY)
    private PlayerCharacter playerCharacter;

    // == getters ==
    public PlayerCharacter getPlayerCharacter() {
        return this.playerCharacter;
    }

    // == type-specific ==
    public Item update(Item item) {
        if(item.getPlayerCharacter().getId()!=null && !item.getPlayerCharacter().getId().equals("")) this.setPlayerCharacter(item.getPlayerCharacter());
        if(item.getName()!=null && !item.getName().equals("")) this.setName(item.getName());
        if(item.getLevel()!=-1) this.setLevel(item.getLevel());
        if(item.getDurability()!=-1) this.setDurability(item.getDurability());

        return this;
    }
}
