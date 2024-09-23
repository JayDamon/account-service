package com.factotum.accountservice.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    @JsonProperty("accountType")
    private String accountType;

    @JsonProperty("accountSubType")
    private String accountSubType;

}
