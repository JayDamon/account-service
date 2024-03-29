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
import java.util.UUID;

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
    @Column("account_type_id")
    private UUID id;

    @Column("full_account_type")
    private String fullName;

    @Column("short_account_type")
    private String shortName;

}
