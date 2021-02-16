package com.factotum.setzer.model;

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

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("account_type")
public class AccountType implements Serializable {

    @Serial
    private static final long serialVersionUID = 1;

    @Id
    @Column("id")
    private Integer id;

    @Column("full_account_type")
    private String fullName;

    @Column("short_account_type")
    private String shortName;

}
