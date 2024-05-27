package com.threepounds.cityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
public class CityServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CityServiceApplication.class, args);
    }

}
