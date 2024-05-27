package com.threepounds.pureenergy.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("food", r -> r.path("/food/**")
						.filters(f -> f.stripPrefix(1))
						.uri("lb://food-service"))
				.route("city", r -> r.path("/city/**")
						.filters(f -> f.stripPrefix(1))
						.uri("lb://city-service"))
				.route("auth", r -> r.path("/auth/**")
						.filters(f -> f.stripPrefix(1))
						.uri("lb://auth-service"))
				.route("restaurant", r -> r.path("/restaurant/**")
						.filters(f -> f.stripPrefix(1))
						.uri("lb://restaurant-service"))
				.build();
	}

}
