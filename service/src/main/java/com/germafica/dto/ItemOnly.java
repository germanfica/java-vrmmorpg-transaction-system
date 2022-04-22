package com.germafica.dto;

import lombok.Value;

@Value
public class ItemOnly {
    private String name, description;
    private int level;
    private Boolean tradable;
}
