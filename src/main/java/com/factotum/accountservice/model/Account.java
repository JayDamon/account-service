package com.factotum.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("account")
public class Account implements Serializable {

    @Serial
    private static final long serialVersionUID = 1;

    @Id
    @Column("account_id")
    private UUID id;

    @Column("name")
    private String name;

    @Column("plaid_id")
    private String plaidId;

    @Column("item_id")
    private String itemId;

    @Column("official_name")
    private String officialName;

    @Column("available_balance")
    private BigDecimal availableBalance;

    @Column("current_balance")
    private BigDecimal currentBalance;

    @Column("starting_balance")
    private BigDecimal startingBalance;

    @Column("account_limit")
    private BigDecimal limit;

    @Column("is_primary_account")
    private Boolean isPrimaryAccount;

    @Column("is_in_cash_flow")
    private Boolean isInCashFlow;

    @Column("account_type_id")
    private UUID accountTypeId;

    @Column("account_type")
    private String accountTypeName;

    @Column("account_sub_type")
    private String accountSubTypeName;

    @Column("tenant_id")
    private String tenantId;

}
