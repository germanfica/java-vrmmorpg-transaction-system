package com.germafica.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class PlayerCharacterOnly {
    @JsonProperty("account_id")
    private String accountId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("level")
    private int level;

    @JsonProperty("health")
    private int health;

    @JsonProperty("experience")
    private int experience;

    @JsonProperty("x")
    private float x;

    @JsonProperty("y")
    private float y;

    @JsonProperty("z")
    private float z;
}
