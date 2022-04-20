package com.germafica.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.germafica.entity.Item;
import lombok.NonNull;

import java.util.List;

public class InventoryDto {
    @JsonProperty("id")
    @NonNull
    private int id;

    @JsonProperty("slot")
    @NonNull private int slot;

    @JsonProperty("slots_number")
    @NonNull private int slotsNumber;

    @JsonProperty("tradable")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @NonNull private boolean tradable;

    @JsonProperty("game_objects")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private List<Item> gameObjects;
}
