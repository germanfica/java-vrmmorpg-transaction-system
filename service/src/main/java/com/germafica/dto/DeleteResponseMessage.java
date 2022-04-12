package com.germafica.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteResponseMessage {
    @JsonProperty("id")
    String id;
    @JsonProperty("object")
    String object;
    @JsonProperty("is_deleted")
    Boolean isDeleted;
}
