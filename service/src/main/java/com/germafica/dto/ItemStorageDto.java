package com.germafica.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.germafica.entity.Item;
import lombok.NonNull;

import java.util.List;

public class ItemStorageDto {
    @JsonProperty("id")
    @NonNull
    private int id;

    @JsonProperty("items")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private List<Item> items;
}
