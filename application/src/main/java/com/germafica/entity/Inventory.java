package com.germafica.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
}
