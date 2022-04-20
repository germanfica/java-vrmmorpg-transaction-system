package com.germafica.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.germafica.entity.Item;
import lombok.Value;

import java.util.List;

@Value
public class InventoryOnly {
    @JsonProperty("slot")
    private int slot;

    @JsonProperty("slots_number")
    private int slotsNumber;

    @JsonProperty("game_objects")
    private List<Item> gameObjects;
}
