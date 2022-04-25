package com.germafica.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class ItemOnly {
    @JsonProperty("player_character_id")
    private String playerCharacterId;
    private String name;
    private int level, durability;
}
