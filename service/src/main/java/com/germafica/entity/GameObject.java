package com.germafica.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor // JPA requires that this constructor be defined as public or protected
@Entity(name = "GameObject")
@Table(name = "game_object")
public class GameObject {
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
    //TODO: Fix stores relationship
    @Getter(value = AccessLevel.NONE)
    @ManyToOne(fetch = FetchType.LAZY)
    private GameObject gameObject;
}
