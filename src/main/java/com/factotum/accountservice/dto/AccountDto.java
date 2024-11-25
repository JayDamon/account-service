package com.factotum.accountservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1;

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("friendlyName")
    private String friendlyName;

    @NotNull
    @JsonProperty("name")
    private String name;

    @JsonProperty("mask")
    private String mask;

    @JsonProperty("availableBalance")
    private BigDecimal availableBalance;

    @NotNull
    @JsonProperty("startingBalance")
    private BigDecimal startingBalance;

    @JsonProperty("currentBalance")
    private BigDecimal currentBalance;

    @JsonProperty("limit")
    private BigDecimal limit;

    @JsonProperty("officialCurrencyCode")
    private String officialCurrencyCode;

    @JsonProperty("unofficialCurrencyCode")
    private String unofficialCurrencyCode;

    @JsonProperty("institutionId")
    private String institutionId;

    @JsonProperty("institutionName")
    private String institutionName;

    @JsonProperty("isPrimary")
    private Boolean isPrimaryAccount;

    @JsonProperty("isInCashFlow")
    private Boolean isInCashFlow;

    @JsonProperty("accountType")
    private String accountTypeName;

    @JsonProperty("accountSubType")
    private String accountSubTypeName;
}
