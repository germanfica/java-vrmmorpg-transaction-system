package com.germafica.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class PlayerCharacterOnly {
    @JsonProperty("name")
    private String name;

    @JsonProperty("level")
    private int level;

    @JsonProperty("health")
    private int health;

    @JsonProperty("experience")
    private int experience;
}
