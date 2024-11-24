package com.factotum.accountservice.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
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

    @JsonProperty("accounts")
    private List<UpdateAccountMessage> accounts;

}
