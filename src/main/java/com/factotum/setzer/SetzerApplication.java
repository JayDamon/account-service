package com.factotum.setzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SetzerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SetzerApplication.class, args);
    }

}
