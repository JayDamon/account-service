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

    @Column("account_type_id")
    private UUID accountTypeId;

    @Column("starting_balance")
    private BigDecimal startingBalance;

    @Column("current_balance")
    private BigDecimal currentBalance;

    @Column("is_primary_account")
    private Boolean isPrimaryAccount;

    @Column("is_in_cash_flow")
    private Boolean isInCashFlow;

    @Column("tenant_id")
    private String tenantId;

}
