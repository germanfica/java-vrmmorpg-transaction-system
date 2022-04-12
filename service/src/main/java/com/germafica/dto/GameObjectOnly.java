package com.germafica.dto;

import lombok.Value;

@Value
public class GameObjectOnly {
    private String name, description;
    private int level;
    private Boolean tradable;
}
