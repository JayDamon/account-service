package com.factotum.accountservice.config;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

public class ConnectionFactoryBase {

    @Configuration
    static class Config {

        @Bean
        public ConnectionFactory connectionFactory(DataSource dataSource) {
            return new EmbeddedPostgresConnectionFactory(dataSource);
        }
    }

}
