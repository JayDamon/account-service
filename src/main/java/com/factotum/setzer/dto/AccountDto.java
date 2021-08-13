package com.factotum.setzer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
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

    @NotNull
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("type")
    private AccountTypeDto accountType;

    @NotNull
    @JsonProperty("startingBalance")
    private BigDecimal startingBalance;

    @JsonProperty("currentBalance")
    private BigDecimal currentBalance;

    @JsonProperty("isPrimary")
    private Boolean isPrimaryAccount;

    @JsonProperty("isInCashFlow")
    private Boolean isInCashFlow;

}
