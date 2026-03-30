package com.tkkt.race_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RaceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RaceServiceApplication.class, args);
    }

}
