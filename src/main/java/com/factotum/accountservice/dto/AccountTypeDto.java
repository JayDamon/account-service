package com.factotum.accountservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountTypeDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1;

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("fullName")
    private String fullName;

    @JsonProperty("shortName")
    private String shortName;

}
