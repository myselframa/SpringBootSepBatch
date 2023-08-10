package com.fmc;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}
	
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		
		return builder.routes().route(p->p
				.path("/fmc/accounts/**")
				.filters(f->f.rewritePath("/fmc/accounts/(?<segment>.*)","/${segment}")
						.addResponseHeader("X-Respone-Time",new Date().toString()))
				.uri("lb://ACCOUNTS"))
				.route(p->p
						.path("/fmc/loans/**")
						.filters(f->f.rewritePath("/fmc/loans/(?<segment>.*)","/${segment}")
								.addResponseHeader("X-Respone-Time",new Date().toString()))
						.uri("lb://LOANS"))
				.route(p->p
						.path("/fmc/cards/**")
						.filters(f->f.rewritePath("/fmc/cards/(?<segment>.*)","/${segment}")
								.addResponseHeader("X-Respone-Time",new Date().toString()))
						.uri("lb://CARDS")).build();
	}

}
