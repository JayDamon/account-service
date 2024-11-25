package com.factotum.accountservice.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Column;
import reactor.core.publisher.Flux;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateAccountItemMessage implements Serializable {

    @JsonProperty("itemId")
    private String itemId;

    @JsonProperty("institutionId")
    private String institutionId;

    @JsonProperty("institutionName")
    private String institutionName;

    @JsonProperty("url")
    private String url;

    @JsonProperty("primaryColor")
    private String primaryColor;

    @JsonProperty("logo")
    private String logo;

    @JsonProperty("tenantId")
    private String tenantId;

    @JsonProperty("accounts")
    private List<UpdateAccountMessage> accounts;

}
