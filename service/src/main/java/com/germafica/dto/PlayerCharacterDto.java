package com.germafica.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import lombok.Value;

@Value
public class PlayerCharacterDto {
    @JsonProperty("id")
    @NonNull
    private String id;

    @JsonProperty("name")
    @NonNull private String name;

    @JsonProperty("level")
    @NonNull private int level;

    @JsonProperty("health")
    @NonNull private int health;

    @JsonProperty("experience")
    @NonNull private int experience;
}
