package com.germafica.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import lombok.Value;

@Value
public class ItemDto {
    @JsonProperty("id")
    @NonNull
    private int id;

    @JsonProperty("name")
    @NonNull private String name;

    @JsonProperty("level")
    @NonNull private int level;

    @JsonProperty("description")
    @NonNull private String description;

    @JsonProperty("tradable")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @NonNull private boolean tradable;
}
