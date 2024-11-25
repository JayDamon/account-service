package com.factotum.accountservice.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.ShiftRight;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateAccountMessage implements Serializable {

    @JsonProperty("tenantId")
    private String tenantId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("mask")
    private String mask;

    @JsonProperty("id")
    private String plaidId;

    @JsonProperty("itemId")
    private String itemId;

    @JsonProperty("officialName")
    private String officialName;

    @JsonProperty("availableBalance")
    private BigDecimal availableBalance;

    @JsonProperty("currentBalance")
    private BigDecimal currentBalance;

    @JsonProperty("limit")
    private BigDecimal limit;

    @JsonProperty("officialCurrencyCode")
    private String officialCurrencyCode;

    @JsonProperty("unofficialCurrencyCode")
    private String unofficialCurrencyCode;

    @JsonProperty("accountType")
    private String accountTypeName;

    @JsonProperty("accountSubType")
    private String accountSubTypeName;

}
