package com.factotum.setzer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
public class Account extends DateAuditable implements Serializable {

    @Serial
    private static final long serialVersionUID = 1;

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "account_type_id", nullable = false)
    private AccountType accountType;

    @Column(name = "starting_balance", nullable = false)
    private BigDecimal startingBalance;

    @Column(name = "current_balance")
    private BigDecimal currentBalance;

    @Column(name = "is_primary_account")
    private Boolean isPrimaryAccount;

    @Column(name = "is_in_cash_flow")
    private Boolean isInCashFlow;

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getStartingBalance() {
        return startingBalance;
    }

    public void setStartingBalance(BigDecimal startingBalance) {
        this.startingBalance = startingBalance;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Boolean getPrimaryAccount() {
        return isPrimaryAccount;
    }

    public void setPrimaryAccount(Boolean primaryAccount) {
        isPrimaryAccount = primaryAccount;
    }

    public Boolean getInCashFlow() {
        return isInCashFlow;
    }

    public void setInCashFlow(Boolean inCashFlow) {
        isInCashFlow = inCashFlow;
    }
}
