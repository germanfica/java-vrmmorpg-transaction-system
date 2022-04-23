package com.germafica.entity;

import lombok.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    @NonNull
    private String name;

    @NonNull
    private int level;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    @NonNull
    private String description;

    @Column(nullable = false, columnDefinition = "TINYINT")
    @NonNull
    private Boolean tradable;

    // == associations ==

    // == owns relationship ==
    @Getter(value = AccessLevel.NONE)
    @ManyToOne(fetch = FetchType.LAZY)
    private PlayerCharacter playerCharacter;

    // == type-specific ==
    public Item update(Item item) {
        if(item.getName()!=null) this.setName(item.getName());
        if(item.getLevel()!=-1) this.setLevel(item.getLevel());
        if(item.getDescription()!=null) this.setDescription(item.getDescription());
        if(item.getTradable()!=null) this.setTradable(item.getTradable());

        return this;
    }
}
