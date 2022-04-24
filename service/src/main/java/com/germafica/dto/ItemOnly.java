package com.germafica.dto;

import lombok.Value;

@Value
public class ItemOnly {
    private String name;
    private int level, durability;
}
