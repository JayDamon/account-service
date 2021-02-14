package com.factotum.setzer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "account_type")
public class AccountType extends DateAuditable implements Serializable {

    @Serial
    private static final long serialVersionUID = 1;

    @Id
    @Column(name = "account_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_account_type")
    private String fullName;

    @Column(name = "short_account_type")
    private String shortName;

    public AccountType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullType) {
        this.fullName = fullType;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortType) {
        this.shortName = shortType;
    }
}
