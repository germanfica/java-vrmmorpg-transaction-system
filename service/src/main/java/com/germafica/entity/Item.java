package com.germafica.entity;

import com.germafica.entity.relationship.ItemStorageItem;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    // == stores relationship ==
    @OneToMany(
            mappedBy = "item",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ItemStorageItem> owners = new ArrayList<>();
}
