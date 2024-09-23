package com.factotum.accountservice.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateAccountExchangeConfig {

    public static final String UPDATE_ACCOUNT_EXCHANGE = "account_update";

    @Bean
    public FanoutExchange updateAccountExchange() {
        return new FanoutExchange(UPDATE_ACCOUNT_EXCHANGE);
    }

    @Bean
    public Queue updateAccountQueue() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding udpateAccountExchangeBinding(FanoutExchange updateAccountExchange, Queue updateAccountQueue) {
        return BindingBuilder.bind(updateAccountQueue).to(updateAccountExchange);
    }

}
