package com.threepounds.baseservice.rest;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.threepounds")
public class FeignClientConfiguration {

}