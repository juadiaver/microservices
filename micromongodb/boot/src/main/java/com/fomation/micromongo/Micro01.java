package com.fomation.micromongo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class Micro01 {

	public static void main(String[] args) {
		SpringApplication.run(Micro01.class, args);

	}

}
