package com.micromongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Micro02App {
    public static void main(String[] args) {
        SpringApplication.run(Micro02App.class,args);
    }
}