package com.factotum.setzer.config;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

@Configuration
@EnableR2dbcRepositories(basePackages = {"com.factotum.setzer.repository"})
public class JpaConfiguration {

    @Bean
    @Profile({"test"})
    public ConnectionFactoryInitializer initializer(@Qualifier("connectionFactory") ConnectionFactory connectionFactory) {
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator(
                new ClassPathResource("test_data/drop_tables.sql"),
                new ClassPathResource("db/migration/V1_0__create_mm_account_schema.sql"),
                new ClassPathResource("db/migration/V2_0__add_tenant_id_column.sql"),
                new ClassPathResource("db/migration/V2_3__add_non_null_constraint.sql"),
                new ClassPathResource("test_data/V1_1__test_accounts.sql"),
                new ClassPathResource("test_data/V2_1__add_tenant_id_in_tables.sql")
        );
        initializer.setDatabasePopulator(populator);
        return initializer;
    }

}
