package com.germafica.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import lombok.Value;

@Value
public class AccountDto {
    @JsonProperty("id")
    @NonNull
    private int id;

    @JsonProperty("username")
    @NonNull private String username;

    @JsonProperty("first_name")
    @NonNull private String firstName;

    @JsonProperty("last_name")
    @NonNull private String lastName;

    @JsonProperty("email")
    @NonNull private String email;
}
