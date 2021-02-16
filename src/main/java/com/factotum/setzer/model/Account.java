package com.factotum.setzer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("account")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account implements Serializable {

    @Serial
    private static final long serialVersionUID = 1;

    @Id
    @Column("id")
    @JsonProperty("id")
    private Long id;

    @Column("name")
    @JsonProperty("name")
    private String name;

    @Column("account_type_id")
    @JsonIgnore
    private Integer accountTypeId;

    @Transient
    @JsonProperty("type")
    private AccountType accountType;

    @Column("starting_balance")
    @JsonProperty("startingBalance")
    private BigDecimal startingBalance;

    @Column("current_balance")
    @JsonProperty("currentBalance")
    private BigDecimal currentBalance;

    @Column("is_primary_account")
    @JsonProperty("isPrimary")
    private Boolean isPrimaryAccount;

    @Column("is_in_cash_flow")
    @JsonProperty("isInCashFlow")
    private Boolean isInCashFlow;

}
