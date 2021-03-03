package com.factotum.setzer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private AccountTypeDto accountType;

    @JsonProperty("startingBalance")
    private BigDecimal startingBalance;

    @JsonProperty("currentBalance")
    private BigDecimal currentBalance;

    @JsonProperty("isPrimary")
    private Boolean isPrimaryAccount;

    @JsonProperty("isInCashFlow")
    private Boolean isInCashFlow;

}
