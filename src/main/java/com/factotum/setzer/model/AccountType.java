package com.factotum.setzer.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountType implements Serializable {

    @Serial
    private static final long serialVersionUID = 1;

    @Id
    @Column("id")
    @JsonProperty("id")
    private Integer id;

    @Column("full_account_type")
    @JsonProperty("fullName")
    private String fullName;

    @Column("short_account_type")
    @JsonProperty("shortName")
    private String shortName;

}
