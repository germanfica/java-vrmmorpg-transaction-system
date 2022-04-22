package com.germafica.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.germafica.entity.Item;
import lombok.Value;

import java.util.List;

@Value
public class ItemStorageOnly {
    @JsonProperty("items")
    private List<Item> items;
}
