package com.germafica.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
//@NoArgsConstructor // JPA requires that this constructor be defined as public or protected
@Entity(name = "Inventory")
@Table(name = "inventory")
public class Inventory {
    // == fields ==
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int slot;

    @Column(nullable = false)
    private int slotsNumber;

    // == associations ==

    // == owns relationship ==
    @Getter(value = AccessLevel.NONE)
    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
    @LazyCollection( LazyCollectionOption.EXTRA )
    private Set<User> users = new HashSet<>();

    // == stores relationship ==
    @Getter(value = AccessLevel.NONE)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(name="stores",
//            joinColumns={@JoinColumn(name="gameObjectId")},
//            inverseJoinColumns={@JoinColumn(name="inventoryId")})
    @JoinTable(name="stores")
    private List<Item> gameObjects = new ArrayList<>();
}
