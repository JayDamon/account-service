package com.factotum.accountservice.model;

import lombok.*;
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
@Table("item")
public class Item implements Serializable {

    @Serial
    private static final long serialVersionUID = 1;

    @Id
    @Column("item_id")
    private String id;

    @Column("institution_id")
    private String institutionId;

    @Column("institution_name")
    private String institutionName;

    @Column("url")
    private String url;

    @Column("primary_color")
    private String primaryColor;

    @Column("logo")
    private String logo;

    @Column("tenant_id")
    private String tenantId;
}
